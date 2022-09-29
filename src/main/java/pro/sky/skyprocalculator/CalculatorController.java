package pro.sky.skyprocalculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")

public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String welcome() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping("/plus")
    public String plus(@RequestParam(name = "num1") Integer a,
                       @RequestParam(name = "num2") Integer b) {
        return a + "+" + b + "=" + calculatorService.pluse(a, b);
    }

    @GetMapping("/minus")
    public String minus(@RequestParam(name = "num1") Integer a,
                       @RequestParam(name = "num2") Integer b) {
        return a + "-" + b + "=" + calculatorService.minus(a, b);
    }
    @GetMapping("/multiply")
    public String multiply(@RequestParam(name = "num1") Integer a,
                       @RequestParam(name = "num2") Integer b) {
        return a + "*" + b + "=" + calculatorService.multiply(a, b);
    }
    @GetMapping("/divide")
    public String divide(@RequestParam(name = "num1") Integer a,
                       @RequestParam(name = "num2") Integer b) {
        if (b == 0)
            return "Делить на 0 нельзя!";
        return a + "/" + b + "=" + calculatorService.divide(a, b);

    }
}
