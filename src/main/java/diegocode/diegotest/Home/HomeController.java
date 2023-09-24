package diegocode.diegotest.Home;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/locales")
@RequiredArgsConstructor
public class HomeController {



    @PostMapping(value = "home")
    public String bienvenido() {
        return "Bienvenido";
    }

    


    

}