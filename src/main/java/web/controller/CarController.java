package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {
    @Autowired
    List<Car> listCar;


//    @GetMapping(value = "/cars")
//    public void counterCars(@RequestParam("count")String strCount)  {
//
//        try {
//            count = Integer.valueOf(strCount);
//        } catch(Exception ignored) {}
//    }

    @GetMapping(value = "/cars")
    public String printWelcome(ModelMap model, HttpServletRequest servet) {
        List<String> messages = new ArrayList<>();
        int count = 5;
        try {
            count = Integer.parseInt(servet.getParameter("count"));
        }catch(Exception ignored) {}
        if(count >= 5) {
            for (Car car : listCar) {
                messages.add(car.toString());
            }
        } else if(count < 1) {
            messages.add("I don't care what to show you");
        } else {
            for (int i = 0; i < count; i++) {
                messages.add(listCar.get(i).toString());
            }
        }

        model.addAttribute("messages", messages);
        return "cars";
    }

}
