package com.main.fashionstore.Controller.admin;

import java.util.List;

import com.main.fashionstore.Dao.CategoryDao;
import com.main.fashionstore.Entity.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("admin/report")
public class ReportController {
	@Autowired

	@RequestMapping("")
	public String inventory() {

		return "index";
	}
}
