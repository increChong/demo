package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    //获取学生列表
    @GetMapping(value = "/stus")
    public List<Student> studentList(){
        return studentRepository.findAll();
    }

    //根据id查找学生
    @GetMapping(value = "/stus/{id}")
    public Student getStudentById(@PathVariable("id") Integer id){
        return studentRepository.findOne(id);
    }

    //添加一个学生
    @PostMapping("/stus")
    public Student addStudent(@RequestParam("name") String name,
                              @RequestParam("age") Integer age,
                              @RequestParam("sex") Character sex){
        Student student=new Student();
        student.setSex(sex);
        student.setName(name);
        student.setAge(age);

        return studentRepository.save(student);
    }
    //通过年龄查询学生列表
    @GetMapping("/stus/age/{age}")
    public List<Student> getStudentByAge(@PathVariable("age") Integer age){

        return studentRepository.findByAge(age);

    }

    //更新一个学生
    @PutMapping("/stus/{id}")
    public Student studentUpdate(@PathVariable("id") Integer id,
                                 @RequestParam("name") String name,
                                 @RequestParam("age") Integer age,
                                 @RequestParam("sex") Character sex){
        Student student=new Student();
        student.setId(id);
        student.setAge(age);
        student.setName(name);
        student.setSex(sex);

        return  studentRepository.save(student);

    }

    //删除一个学生
    @DeleteMapping("/stus/{id}")
    public void deleteStudent(@PathVariable("id") Integer id){
        studentRepository.delete(id);

    }


//   @Autowired
//   private StudentProperties studentProperties;
//
//    //@RequestMapping(value = {"/hello","/hi"},method = RequestMethod.GET)
//    @GetMapping("/hello")
//    public String index(@RequestParam(value = "name",required = false,defaultValue = "he") String name){
//        //return "<input type='text' value='HelloWorld'>";
//        return "name:"+name;
//        //return studentProperties.getAge();
//    }
}
