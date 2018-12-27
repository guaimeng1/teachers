package com.tt.teachers.Controller;

import com.tt.teachers.dao.SubjectDao;
import com.tt.teachers.pojo.Subject;
import com.tt.teachers.service.SubjectService;
import com.tt.teachers.utils.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/sub")
public class SubjectController {
    @Resource
    private SubjectService subjectService;

    @RequestMapping("/subject")
    public String subject() {
        return "/subject/subject";
    }
    @GetMapping("/findSubAll")
    @ResponseBody
    public Object findSubAll() {
        List<Subject> list = subjectService.findSubAll();
        return list;
    }

    @RequestMapping(value = "/deleteSubject/{subjectNo}",method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteSubject(@PathVariable Integer subjectNo) {
        int result = subjectService.deleteSubject(subjectNo);
        if(result>0){
            return JsonResult.ok("删除成功！",result);
        }
        return JsonResult.no("删除失败！",result);
    }
}
