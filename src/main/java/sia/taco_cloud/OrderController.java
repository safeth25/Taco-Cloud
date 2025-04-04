package sia.taco_cloud;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/orders")
public class OrderController {
    
    @GetMapping
    public String orderForm(Model model){
        model.addAttribute("order", new Order());
        return "orderForm";
    }
}
