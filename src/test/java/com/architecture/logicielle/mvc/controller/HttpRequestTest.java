package com.architecture.logicielle.mvc.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.architecture.logicielle.mvc.data.UniteEnseignementView;
import com.architecture.logicielle.mvc.data.UserView;
import com.architecture.logicielle.repository.StageRepository;
import com.architecture.logicielle.repository.UniteEnseignementRepository;
import com.architecture.logicielle.repository.UserRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ControllerTest.class, secure = false)
public class HttpRequestTest {
	
	@Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;
    private UserView userView;
    private UniteEnseignementView ue;
    
    @MockBean
	private UserRepository userRepository;
    @MockBean
	private UniteEnseignementRepository ueRepository;
    @MockBean
	private StageRepository stageRepository;

    @Before
    public void setup() {
        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
        this.mockMvc = builder.build();
    }
    
    @Test
    public void testShowFromInscription() throws Exception {
        ResultMatcher msg = MockMvcResultMatchers.model()
                            .attribute("userView", userView);
    		
        mockMvc.perform(get("/inscription")
        	       .header("host", "localhost:8080"))
        	       .andExpect(status().isOk())
        	       .andExpect(msg);

     }
    
    /*@Test
    public void testInscriptionSubmit() throws Exception {
    	File file = null;
    	Long id = (long) 1111;
        userView = new UserView("alexis","fiers","student","alexis.fiers@gmail.com","admin",file,id);
    		ResultMatcher msg = MockMvcResultMatchers.model()
                            .attribute("user", userView);
    		
        mockMvc.perform(get("/inscription")
        	       .header("host", "localhost:8080"))
        	       .andExpect(status().isOk())
        	       .andExpect(msg);
     }*/
    
    /*@Test
    public void testUESubmitn() throws Exception {
        ue = new UniteEnseignementView();
    		ResultMatcher msg = MockMvcResultMatchers.model()
                            .attribute("ue", ue);
    		
        mockMvc.perform(get("/ue")
        	       .header("host", "localhost:8080"))
        	       .andExpect(status().isOk())
        	       .andExpect(msg);

     }*/

}
