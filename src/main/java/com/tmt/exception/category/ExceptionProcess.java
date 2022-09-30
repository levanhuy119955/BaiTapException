package com.tmt.exception.category;

import com.tmt.exception.entity.Category;
import com.tmt.exception.entity.CategoryExceptionEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionProcess {

    @ExceptionHandler(value = ExceptionGlobal.class)
    public ResponseEntity<Object> exception(ExceptionGlobal exceptionGlobal){
        CategoryExceptionEntity categoryEx = new CategoryExceptionEntity();
            categoryEx.setCode(04105);
            categoryEx.setMessage("Category name độ dài phải lớn hơn 5");
            categoryEx.setTimestamp(new Date());
            return new ResponseEntity<>(categoryEx, HttpStatus.BAD_REQUEST);
    }

//    @ExceptionHandler (value = ExceptionGlobal.class)
//    public Map<Object,String> mapExxception(ExceptionGlobal excepGlobal){
//        CategoryExceptionEntity categoryEx = new CategoryExceptionEntity();
//        Map<Object,String> maps = new HashMap<>();
//
//        maps.put(categoryEx.getCode(),"04105");
//        maps.put(categoryEx.getMessage(),"Category name độ dài phải lớn hơn 5");
//        maps.put(categoryEx.getTimestamp().toString(),"");
//
//        return maps;
//    }
}
