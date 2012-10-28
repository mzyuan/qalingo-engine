/**
 * Most of the code in the Qalingo project is copyrighted Hoteia and licensed
 * under the Apache License Version 2.0 (release version ${license.version})
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *                   Copyright (c) Hoteia, 2012-2013
 * http://www.hoteia.com - http://twitter.com/hoteia - contact@hoteia.com
 *
 */
package fr.hoteia.qalingo.web.mvc.factory;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import fr.hoteia.qalingo.core.common.domain.EngineSettingValue;
import fr.hoteia.qalingo.core.common.domain.User;

public interface FormFactory {

	void buildEngineSettingValueEditForm(HttpServletRequest request, ModelAndView modelAndView, EngineSettingValue engineSettingValue) throws Exception;

	void buildUserForm(HttpServletRequest request, ModelAndView modelAndView, User user) throws Exception;

	void buildEngineSettingQuickSearchForm(HttpServletRequest request, ModelAndView modelAndView) throws Exception;
	
	void buildUserQuickSearchForm(HttpServletRequest request, ModelAndView modelAndView) throws Exception;

	void buildBatchQuickSearchForm(HttpServletRequest request, ModelAndView modelAndView) throws Exception;
}