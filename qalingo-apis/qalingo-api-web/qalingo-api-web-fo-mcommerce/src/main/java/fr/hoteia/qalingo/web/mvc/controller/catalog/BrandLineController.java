/**
 * Most of the code in the Qalingo project is copyrighted Hoteia and licensed
 * under the Apache License Version 2.0 (release version ${license.version})
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *                   Copyright (c) Hoteia, 2012-2013
 * http://www.hoteia.com - http://twitter.com/hoteia - contact@hoteia.com
 *
 */
package fr.hoteia.qalingo.web.mvc.controller.catalog;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.hoteia.qalingo.core.Constants;
import fr.hoteia.qalingo.core.common.domain.MarketArea;
import fr.hoteia.qalingo.core.common.domain.ProductBrand;
import fr.hoteia.qalingo.core.common.service.ProductBrandService;
import fr.hoteia.qalingo.core.web.servlet.ModelAndViewThemeDevice;
import fr.hoteia.qalingo.web.mvc.controller.AbstractQalingoController;

/**
 * 
 */
@Controller
public class BrandLineController extends AbstractQalingoController {

	@Autowired
	protected ProductBrandService productBrandService;
	
	@RequestMapping("/brand-line.html*")
	public ModelAndView brandLine(final HttpServletRequest request, final HttpServletResponse response) throws Exception {
		ModelAndViewThemeDevice modelAndView = new ModelAndViewThemeDevice(getCurrentVelocityPath(request), "catalog/brand-line");

		final MarketArea currentMarketArea = requestUtil.getCurrentMarketArea(request);
		final String brandCode = request.getParameter(Constants.REQUEST_PARAM_BRAND_CODE);
		final ProductBrand productBrand = productBrandService.getProductBrandByCode(currentMarketArea.getId(), brandCode);
		
		final String titleKeyPrefixSufix = "brand.line";
		initPage(request, response, modelAndView, titleKeyPrefixSufix);
		modelAndViewFactory.initPageBrandLine(request, response, modelAndView, productBrand, titleKeyPrefixSufix);
		
        return modelAndView;
	}
    
}