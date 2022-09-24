package com.pentagono.pentagono.controller.front;

import ch.qos.logback.core.encoder.Encoder;
import com.pentagono.pentagono.model.Employee;
import com.pentagono.pentagono.model.Enterprise;
import com.pentagono.pentagono.model.Transaction;
import com.pentagono.pentagono.service.IEmployeeService;
import com.pentagono.pentagono.service.IEnterpriseService;
import com.pentagono.pentagono.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/")
public class FrontController {
    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private IEnterpriseService iEnterpriseService;
    @Autowired
    private ITransactionService iTransactionService;
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    /*CODIGO PARA EMPLEADO*/
    @RequestMapping(value = "/employeeS", method = RequestMethod.GET)
    public String employeeS(Model model) {
        List<Employee> employees = this.iEmployeeService.getAllEmployees();
        model.addAttribute("employeeS", employees);
        return "see_employee";
    }


    @GetMapping("/employeeN")
    public String nuevoEmpleado(Model model, @ModelAttribute("mensaje") String mensaje){
        Employee empl= new Employee();
        model.addAttribute("empl",empl);
        model.addAttribute("mensaje",mensaje);
        List<Enterprise> listaEmpresas= iEnterpriseService.getAllEnterprises();
        model.addAttribute("emprelist",listaEmpresas);
        return "new_employee"; //Llamar HTML
    }


    @PostMapping("/GuardarEmpleado")
    public String guardarEmpleado(Employee empl, RedirectAttributes redirectAttributes){
        /*String passEncriptada=passwordEncoder().encode(empl.getPassword());
        empl.setPassword(passEncriptada);*/
        if(iEmployeeService.saveOrUpdateEmpleado(empl)==true){
            redirectAttributes.addFlashAttribute("mensaje","saveOK");
            return "redirect:/employeeS";
        }
        redirectAttributes.addFlashAttribute("mensaje","saveError");
        return "redirect:/employeeN";
    }

    @GetMapping("/EditarEmpleado/{id}")
    public String editarEmpleado(Model model, @PathVariable Long idEmployee, @ModelAttribute("mensaje") String mensaje){
        Long empl=iEmployeeService.getEmployeeById(idEmployee).getIdEmployee();//ojoa aca hubo cambio  along
        model.addAttribute("empl",empl);
        model.addAttribute("mensaje", mensaje);
        List<Enterprise> listaEmpresas= iEnterpriseService.getAllEnterprises();
        model.addAttribute("emprelist",listaEmpresas);
        return "editarEmpleado";
    }
   /*@PostMapping("/ActualizarEmpleado")
    public String updateEmpleado(@ModelAttribute("empl") Employee empl, RedirectAttributes redirectAttributes){
        Long idEmployee=empl.getIdEmployee();
        String Oldpass=iEmployeeService.getEmployeeById(idEmployee).getPassword();
        if(!empl.getPassword().equals(Oldpass)){
            String passEncriptada= String.valueOf(passwordEncoder().encode(empl.getPassword()));
            //String passEncriptada=passwordEncoder().encode(empl.getPassword());
            empl.setPassword(passEncriptada);
        }
        if(iEmployeeService.saveOrUpdateEmpleado(empl)){
            redirectAttributes.addFlashAttribute("mensaje","updateOK");
            return "redirect:/see_employee";
        }
        redirectAttributes.addFlashAttribute("mensaje","updateError");
        return "redirect:/new_employee/"+empl.getIdEmployee();

    }*/
    @GetMapping("/EliminarEmpleado/{id}")
    public String eliminarEmpleado(@PathVariable Long id, RedirectAttributes redirectAttributes){
        if (iEmployeeService.deleteEmployee(id)){
            redirectAttributes.addFlashAttribute("mensaje","deleteOK");
            return "redirect:/see_employee";
        }
        redirectAttributes.addFlashAttribute("mensaje", "deleteError");
        return "redirect:/new_employee";
    }

    @GetMapping("/Empresa/{id}/Empleados") //Filtrar los empleados por empresa
    public String verEmpleadosPorEmpresa(@PathVariable("id") Long idEmployee, Model model) {
        List<Employee> listaEmpleados = iEmployeeService.obtenerPorEmpresa(idEmployee);
        model.addAttribute("emplelist", listaEmpleados);
        return "see_employee";
    }
        /*CODIGO PARA EMPRESA*/
        @RequestMapping(value = "/enterpriseS", method = RequestMethod.GET)/*Ver Empresas*/
        public String enterpriseS (Model model){
            List<Enterprise> enterprises = this.iEnterpriseService.getAllEnterprises();
            model.addAttribute("enterpriseS", enterprises);
            return "see_enterprise";
        }

        @RequestMapping(value = "/enterpriseN", method = RequestMethod.GET)/*Crear Empresa*/
        public String enterpriseN (@ModelAttribute Enterprise enterprise, Model model){
            model.addAttribute("enterpriseN", new Enterprise());
            return "new_enterprise";
        }


        /*CODIGO PARA TRANSACCION*/


    }
