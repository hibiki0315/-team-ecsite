package jp.co.internous.printemps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.internous.printemps.model.domain.MstProduct;
import jp.co.internous.printemps.model.mapper.MstProductMapper;
import jp.co.internous.printemps.model.session.LoginSession;

@Controller
@RequestMapping("/printemps")
public class IndexController {
	@Autowired
	private MstProductMapper productMapper;
	
	@Autowired
	private LoginSession loginSession;
	

	@RequestMapping("/")
	public String index(Model m) {
		
		if (!loginSession.isLogined() && loginSession.getTmpUserId() == 0) {
			int tmpUserId = (int)(Math.random() * 1000000000 * -1);
			while (tmpUserId > -100000000) {
				tmpUserId *= 10;
			}
			loginSession.setTmpUserId(tmpUserId);
		}
		
		List<MstProduct> products = productMapper.find();
		
		m.addAttribute("selected", 0);
		m.addAttribute("products", products);
		m.addAttribute("loginSession", loginSession);
		return "index";
	}
	
}
