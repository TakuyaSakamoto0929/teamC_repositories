package com.example.demo.controller;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/search")
    public String showSearchPage() {
        return "search";
    }

    @PostMapping("/search")
    public String searchEmployees(
            @RequestParam(required = false) String id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer ageMin,
            @RequestParam(required = false) Integer ageMax,
            @RequestParam(required = false) String kaishiMin,
            @RequestParam(required = false) String kaishiMax,
            @RequestParam(required = false) String shuryoMin,
            @RequestParam(required = false) String shuryoMax,
            Model model) {

        List<String> errors = new ArrayList<>();

        // IDのバリデーション（数値チェック）
        Integer parsedId = null;
        if (id != null && !id.isEmpty()) {
            try {
                parsedId = Integer.parseInt(id);
            } catch (NumberFormatException e) {
                errors.add("社員IDは数値を入力してください。");
            }
        }

        // 日付のバリデーション（形式チェック）
        LocalDate kaishiMinDate = validateDate(kaishiMin, errors);
        LocalDate kaishiMaxDate = validateDate(kaishiMax, errors);
        LocalDate shuryoMinDate = validateDate(shuryoMin, errors);
        LocalDate shuryoMaxDate = validateDate(shuryoMax, errors);

        if (!errors.isEmpty()) {
            model.addAttribute("errors", errors);
            return "search";
        }

        List<Employee> employees = employeeService.searchEmployees(parsedId, name, ageMin, ageMax, kaishiMinDate, kaishiMaxDate, shuryoMinDate, shuryoMaxDate);
        
        model.addAttribute("employees", employees);
        model.addAttribute("resultCount", employees.size());

        // 検索結果がない場合のメッセージ
        if (employees.isEmpty()) {
            model.addAttribute("noResultsMessage", "該当する社員が見つかりませんでした。");
        }

        // 検索フォームに値を保持
        model.addAttribute("id", id);
        model.addAttribute("name", name);
        model.addAttribute("ageMin", ageMin);
        model.addAttribute("ageMax", ageMax);
        model.addAttribute("kaishiMin", kaishiMin);
        model.addAttribute("kaishiMax", kaishiMax);
        model.addAttribute("shuryoMin", shuryoMin);
        model.addAttribute("shuryoMax", shuryoMax);

        return "search";
    }

    // 日付のバリデーションメソッド
    private LocalDate validateDate(String date, List<String> errors) {
        if (date != null && !date.isEmpty()) {
            try {
                return LocalDate.parse(date);
            } catch (DateTimeParseException e) {
                errors.add("日付の形式が正しくありません。");
            }
        }
        return null;
    }
}