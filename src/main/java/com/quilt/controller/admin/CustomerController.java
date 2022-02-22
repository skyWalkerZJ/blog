package com.quilt.controller.admin;
import com.quilt.dao.CustomerDao;
import com.quilt.dto.Result;
import com.quilt.entity.Customer;
import com.quilt.exception.enums.QuiltEnums;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;
@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerDao customerDao;
    @RequestMapping("/addCustomer")
    @ResponseBody
    public Result addReply(HttpSession session,
                           @RequestParam("name")String name,
                           @RequestParam("email") String email){
        Customer customer=new Customer(name,email,10);
        int res=customerDao.AddCustomer(customer);

        if (res == 1){
            return new Result(QuiltEnums.SUCCESS);
        }
        return new Result(QuiltEnums.FAILED);
    }
}
