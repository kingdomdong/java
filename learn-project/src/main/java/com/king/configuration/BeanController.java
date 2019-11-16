package com.king.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/com/king/bean")
public class BeanController {

    @Autowired
    private TestBean testBean;

    /**
     * test bean configuration in Starter class
     *
     * @return
     */
    @GetMapping("/get")
    public String print() {
        // Output:
        //	"username:ComBean test username, url:null, password:null"
        System.out.println(testBean);
        return testBean.toString();
    }

}
