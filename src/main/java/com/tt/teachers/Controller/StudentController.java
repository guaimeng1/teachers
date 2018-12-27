package com.tt.teachers.Controller;

import com.tt.teachers.pojo.Student;
import com.tt.teachers.service.StudentService;
import com.tt.teachers.utils.BaseController;
import com.tt.teachers.utils.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/stu")
public class StudentController extends BaseController{

    @Resource
    private StudentService studentService;

    //登录页面
    @RequestMapping(value = "/login")
    public String login(){
        return "/student/login";
    }
    //主页面
    @RequestMapping(value = "/index")
    public String index(){
        String studentName = (String) getSession().getAttribute(SESSION_KEY);
        if(studentName!=null){
            return "/student/index";
        }
        return REDIRECT+"/stu/login";
    }
    //学生信息页面
    @RequestMapping(value = "/student")
    public String student(){
        return "/student/student";
    }


    //登录方法
    @RequestMapping(value = "/doLogin",method = RequestMethod.POST)
    public String doLogin(){
        String xuehao = getRequest().getParameter("studentNo");
        Integer studentNo = Integer.parseInt(xuehao);
        String loginPwd = getRequest().getParameter("loginPwd");
        Student student = new Student();
        student.setStudentNo(studentNo);
        student.setLoginPwd(loginPwd);
        Student student1 = studentService.doLogin(student);
        if (student1!=null){
            getSession().setAttribute("studentName",student1.getStudentName());
            return FORWARD+"/stu/index";
        }
        return REDIRECT+"/stu/login";
    }

    //注销方法
    @RequestMapping(value = "/logout")
    public String logout(){
       getSession().removeAttribute(SESSION_KEY);
       return REDIRECT+"/stu/login";
    }

    //查询学生方法
    @RequestMapping(value = "/findStuAll",method = RequestMethod.GET)
    @ResponseBody
    public Object findStuAll(){
        List<Student> list = studentService.findStuAll();
        return list;
    }

    //添加学生方法
    @RequestMapping(value = "/updateStu",method = RequestMethod.POST)
    public String updateStu(){
        String xuehao = getRequest().getParameter("stuNo");
        Integer stuNo = Integer.parseInt(xuehao);
        String stuName = getRequest().getParameter("stuName");
        String stuPwd = getRequest().getParameter("stuPwd");
        String stuPhone = getRequest().getParameter("stuPhone");
        Student student = new Student();
        student.setStudentNo(stuNo);
        student.setLoginPwd(stuPwd);
        student.setStudentName(stuName);
        student.setPhone(stuPhone);
        int result = studentService.updateStu(student);
        if (result > 0){
            return FORWARD+"/stu/student";
        }
        return FORWARD+"/stu/student";
    }

    //删除学生方法
    @RequestMapping(value = "/deleteStu/{stuNo}",method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteStu(@PathVariable Integer stuNo){
        int result = studentService.deleteStu(stuNo);
        if (result>0){
            return JsonResult.ok("删除成功！",result);
        }
        return JsonResult.no("删除失败！",result);
    }

    //查询学生方法
    @RequestMapping(value = "/getStuByNo/{studentNo}",method = RequestMethod.GET)
    @ResponseBody
    public Object getStuByNo(@PathVariable Integer studentNo){
        Student student  = studentService.getStuByNo(studentNo);
        if (student!=null){
            return JsonResult.ok("有该学生",student);
        }
        return JsonResult.no("没有该学生",student);
    }
}
