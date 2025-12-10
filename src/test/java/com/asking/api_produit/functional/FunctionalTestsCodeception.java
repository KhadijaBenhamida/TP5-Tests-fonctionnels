package com.asking.api_produit.functional;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.mock.web.MockMultipartFile;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FunctionalTestsCodeception {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Order(1)
    @WithMockUser(username = "Charbel", roles = {"admin"})
    public void test1_Listing() throws Exception {
        mockMvc.perform(get("/listeAvecCon"))
                .andExpect(status().isOk())
                .andExpect(view().name("list"))
                .andExpect(model().attributeExists("produits"));
        
        System.out.println("✓ Test Listing réussi (Codeception-style)");
    }

    @Test
    @Order(2)
    @WithMockUser(username = "Charbel", roles = {"admin"})
    public void test2_Ajout() throws Exception {
        MockMultipartFile file = new MockMultipartFile("imageFile", "test.jpg", "image/jpeg", new byte[0]);
        
        mockMvc.perform(multipart("/create")
                .file(file)
                .with(csrf())
                .param("nom", "ProduitCodeception")
                .param("prix", "200")
                .param("devise", "EUR")
                .param("taxe", "30")
                .param("dateExpiration", "2025-12-31")
                .param("fournisseur", "FournisseurCodeception"))
                .andExpect(status().isOk());
        
        System.out.println("✓ Test Ajout réussi (Codeception-style)");
    }

    @Test
    @Order(3)
    @WithMockUser(username = "Charbel", roles = {"admin"})
    public void test3_Modification() throws Exception {
        MockMultipartFile file = new MockMultipartFile("imageFile", "test.jpg", "image/jpeg", new byte[0]);
        
        mockMvc.perform(multipart("/update/1")
                .file(file)
                .with(csrf())
                .param("id", "1")
                .param("nom", "ProduitModifieCodeception")
                .param("prix", "250")
                .param("devise", "EUR")
                .param("taxe", "35")
                .param("dateExpiration", "2025-12-31")
                .param("fournisseur", "FournisseurModifie"))
                .andExpect(status().isOk());
        
        System.out.println("✓ Test Modification réussi (Codeception-style)");
    }

    @Test
    @Order(4)
    public void test4_Deconnexion() throws Exception {
        mockMvc.perform(post("/logout").with(csrf()))
                .andExpect(status().is3xxRedirection());
        
        System.out.println("✓ Test Déconnexion réussi (Codeception-style)");
    }
}
