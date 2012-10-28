/**
 * Most of the code in the Qalingo project is copyrighted Hoteia and licensed
 * under the Apache License Version 2.0 (release version ${license.version})
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *                   Copyright (c) Hoteia, 2012-2013
 * http://www.hoteia.com - http://twitter.com/hoteia - contact@hoteia.com
 *
 */
package fr.hoteia.qalingo.core.common.service.impl;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import fr.hoteia.qalingo.core.Constants;
import fr.hoteia.qalingo.core.common.domain.Localization;
import fr.hoteia.qalingo.core.common.domain.Market;
import fr.hoteia.qalingo.core.common.domain.MarketArea;
import fr.hoteia.qalingo.core.common.domain.MarketPlace;
import fr.hoteia.qalingo.core.common.domain.Order;
import fr.hoteia.qalingo.core.common.domain.Retailer;
import fr.hoteia.qalingo.core.common.service.UrlService;
import fr.hoteia.qalingo.core.i18n.message.CoreMessageSource;

@Service(value="urlService")
public class UrlServiceImpl implements UrlService {

	@Autowired
	public CoreMessageSource coreMessageSource;
	
	// COMMON
	
	public String buildRootUrl(final HttpServletRequest request) {
		return getContextPrefixUrl(request, null) + "";
	}
	
	public String buildHomeUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer) {
		return buildHomeUrl(request, marketPlace, market,  marketArea, localization, retailer, true);
	}
	
	public String buildHomeUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer, final boolean keepCurrentDomainName) {
		return getFullPrefixUrl(request, marketPlace, market, marketArea, localization, retailer, keepCurrentDomainName)  +  getMessage(localization, "seo.url.welcome")  + "/" + "welcome.html";
	}
	
	public String buildOurCompanyUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer) {
		return buildOurCompanyUrl(request, marketPlace, market,  marketArea, localization, retailer, true);
	}

	public String buildOurCompanyUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer, final boolean keepCurrentDomainName) {
		return getFullPrefixUrl(request, marketPlace, market, marketArea, localization, retailer, keepCurrentDomainName)  +  getMessage(localization, "seo.url.our.company")  + "/" + "our-company.html";
	}

	public String buildClpUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer) {
		return buildClpUrl(request, marketPlace, market,  marketArea, localization, retailer, true);
	}
	
	public String buildClpUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer, final boolean keepCurrentDomainName) {
		return getFullPrefixUrl(request, marketPlace, market, marketArea, localization, retailer, keepCurrentDomainName)  +  getMessage(localization, "seo.url.clp")  + "/" + "clp.html";
	}

	public String buildFollowUsUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer) {
		return buildFollowUsUrl(request, marketPlace, market,  marketArea, localization, retailer, true);
	}
	
	public String buildFollowUsUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer, final boolean keepCurrentDomainName) {
		return getFullPrefixUrl(request, marketPlace, market, marketArea, localization, retailer, keepCurrentDomainName)  +  getMessage(localization, "seo.url.follow.us")  + "/" + "follow-us.html";
	}

	public String buildContactUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer) {
		return buildContactUrl(request, marketPlace, market,  marketArea, localization, retailer, true);
	}
	
	public String buildContactUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer, final boolean keepCurrentDomainName) {
		return getFullPrefixUrl(request, marketPlace, market, marketArea, localization, retailer, keepCurrentDomainName)  +  getMessage(localization, "seo.url.contact.us")  + "/" + "contact-us.html";
	}

	public String buildLegacyUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer) {
		return buildLegacyUrl(request, marketPlace, market,  marketArea, localization, retailer, true);
	}
	
	public String buildLegacyUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer, final boolean keepCurrentDomainName) {
		return getFullPrefixUrl(request, marketPlace, market, marketArea, localization, retailer, keepCurrentDomainName)  +  getMessage(localization, "seo.url.legacy")  + "/" + "legacy.html";
	}

	public String buildFaqUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer) {
		return buildFaqUrl(request, marketPlace, market,  marketArea, localization, retailer, true);
	}
	
	public String buildFaqUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer, final boolean keepCurrentDomainName) {
		return getFullPrefixUrl(request, marketPlace, market, marketArea, localization, retailer, keepCurrentDomainName)  +  getMessage(localization, "seo.url.faq")  + "/" + "faq.html";
	}

	public String buildStoreLocationUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer) {
		return buildStoreLocationUrl(request, marketPlace, market,  marketArea, localization, retailer, true);
	}
	
	public String buildStoreLocationUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer, final boolean keepCurrentDomainName) {
		return getFullPrefixUrl(request, marketPlace, market, marketArea, localization, retailer, keepCurrentDomainName)  +  getMessage(localization, "seo.url.store")  + "/" + "store-location.html";
	}

	public String buildConditionOfUseUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer) {
		return buildConditionOfUseUrl(request, marketPlace, market,  marketArea, localization, retailer, true);
	}
	
	public String buildConditionOfUseUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer, final boolean keepCurrentDomainName) {
		return getFullPrefixUrl(request, marketPlace, market, marketArea, localization, retailer, keepCurrentDomainName)  +  getMessage(localization, "seo.url.conditions.of.use")  + "/" + "conditions-of-use.html";
	}

	public String buildSearchUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer) {
		return buildSearchUrl(request, marketPlace, market, marketArea, localization, retailer, true);
	}
	
	public String buildSearchUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer, final boolean keepCurrentDomainName) {
		return getContextPrefixUrl(request, marketArea) + "sc/search.html";
	}
	
	public String buildChangeLanguageUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer) {
		return buildChangeLanguageUrl(request, marketPlace, market, marketArea, localization, retailer, true);
	}
	
	public String buildChangeLanguageUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer, final boolean keepCurrentDomainName) {
		return getContextPrefixUrl(request, marketArea, keepCurrentDomainName) + getMarketPlacePrefixUrl(marketPlace) + getMarketPrefixUrl(market) + getMarketModePrefixUrl(marketArea) + getLocalizationPrefixUrl(localization) + getRetailerPrefixUrl(retailer) + getSiteDefaultPrefixUrl(localization)  + "/" +  getMessage(localization, "seo.url.welcome")  + "/" + "welcome.html";
	}

	// CATALOG
	
	public String buildProductBrandLineUrlAsProductAxeUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer, final String brandName, final String brandCode) {
		return buildProductBrandLineUrlAsProductAxeUrl(request, marketPlace, market, marketArea, localization, retailer, brandName, brandCode, true);
	}
	
	public String buildProductBrandLineUrlAsProductAxeUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer, final String brandName, final String brandCode, final boolean keepCurrentDomainName) {
		return getFullPrefixUrl(request, marketPlace, market, marketArea, localization, retailer, keepCurrentDomainName)  + handleString(brandName) + "/" + "brand-line-" + brandCode.toLowerCase() + ".html";
	}

	public String buildProductBrandDetailsUrlAsProductAxeUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer, final String brandName, final String brandCode) {
		return buildProductBrandDetailsUrlAsProductAxeUrl(request, marketPlace, market, marketArea, localization, retailer, brandName, brandCode, true);
	}
	
	public String buildProductBrandDetailsUrlAsProductAxeUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer, final String brandName, final String brandCode, final boolean keepCurrentDomainName) {
		return getFullPrefixUrl(request, marketPlace, market, marketArea, localization, retailer, keepCurrentDomainName)  + handleString(brandName) + "/" + "brand-details-" + brandCode.toLowerCase() + ".html";
	}
	
	public String buildProductCategoryUrlAsProductAxeUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer, final String categoryName, final String categoryCode) {
		return buildProductCategoryUrlAsProductAxeUrl(request, marketPlace, market, marketArea, localization, retailer, categoryName, categoryCode, true);
	}
	
	public String buildProductCategoryUrlAsProductAxeUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer, final String categoryName, final String categoryCode, final boolean keepCurrentDomainName) {
		return getFullPrefixUrl(request, marketPlace, market, marketArea, localization, retailer, keepCurrentDomainName)  + handleString(categoryName) + "/" + "product-axe-" + categoryCode.toLowerCase() + ".html";
	}

	public String buildProductCategoryUrlAsProductLineUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer, final String categoryName, final String categoryCode) {
		return buildProductCategoryUrlAsProductLineUrl(request, marketPlace, market, marketArea, localization, retailer, categoryName, categoryCode, true);
	}
	
	public String buildProductCategoryUrlAsProductLineUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer, final String categoryName, final String categoryCode, final boolean keepCurrentDomainName) {
		return getFullPrefixUrl(request, marketPlace, market, marketArea, localization, retailer, keepCurrentDomainName)  + handleString(categoryName) + "/" + "product-line-" + categoryCode.toLowerCase() + ".html";
	}

	public String buildProductUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer, final String categoryName, final String categoryCode, final String productName, final String productCode) {
		return buildProductUrl(request, marketPlace, market, marketArea, localization, retailer, categoryName, categoryCode, productName, productCode, true);
	}
	
	public String buildProductUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer, final String categoryName, final String categoryCode, final String productName, final String productCode, final boolean keepCurrentDomainName) {
		return getFullPrefixUrl(request, marketPlace, market, marketArea, localization, retailer, keepCurrentDomainName)  + handleString(categoryName) + "/" + handleString(productName) + "/" + "product-details-" + categoryCode.toLowerCase() + "-" + productCode.toLowerCase() + ".html";
	}

	public String buildProductAddToCartUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer, final String categoryName, final String categoryCode, final String productName, final String productCode, final String productSkuName, final String productSkuCode) {
		return buildProductAddToCartUrl(request, marketPlace, market, marketArea, localization, retailer, categoryName, categoryCode, productName, productCode, productSkuName, productSkuCode, true);
	}
	
	public String buildProductAddToCartUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer, final String categoryName, final String categoryCode, final String productName, final String productCode, final String productSkuName, final String productSkuCode, final boolean keepCurrentDomainName) {
		return getFullPrefixUrl(request, marketPlace, market, marketArea, localization, retailer, keepCurrentDomainName)  + handleString(categoryName) + "/" + handleString(productName) + "/" + "add-to-cart-" + categoryCode.toLowerCase() + "-" + productCode.toLowerCase() + "-" + productSkuCode.toLowerCase() + ".html";
	}
	
	public String buildProductRemoveFromCartUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer, final String skuCode) {
		return buildProductRemoveFromCartUrl(request, marketPlace, market, marketArea, localization, retailer, skuCode, true);
	}
	
	public String buildProductRemoveFromCartUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer, final String skuCode, final boolean keepCurrentDomainName) {
		return getContextPrefixUrl(request, marketArea) + "sc/remove-from-cart.html" + "?" + Constants.REQUEST_PARAM_PRODUCT_SKU_CODE + "=" + skuCode.toLowerCase();
	}
	
	public String buildProductAddToWishlistUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer, final String categoryName, final String categoryCode, final String productName, final String productCode, final String productSkuName, final String productSkuCode) {
		return buildProductAddToWishlistUrl(request, marketPlace, market, marketArea, localization, retailer, categoryName, categoryCode, productName, productCode, productSkuName, productSkuCode, true);
	}
	
	public String buildProductAddToWishlistUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer, final String categoryName, final String categoryCode, final String productName, final String productCode, final String productSkuName, final String productSkuCode, final boolean keepCurrentDomainName) {
		return getFullPrefixUrl(request, marketPlace, market, marketArea, localization, retailer, keepCurrentDomainName)  + handleString(categoryName) + "/" + handleString(productName) + "/" + "add-to-wishlist-" + categoryCode.toLowerCase() + "-" + productCode.toLowerCase() + "-" + productSkuCode.toLowerCase() + ".html";
	}
	
	public String buildProductRemoveFromWishlistUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer, final String skuCode) {
		return buildProductRemoveFromWishlistUrl(request, marketPlace, market, marketArea, localization, retailer, skuCode, true);
	}
	
	public String buildProductRemoveFromWishlistUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer, final String skuCode, final boolean keepCurrentDomainName) {
		return getContextPrefixUrl(request, marketArea) + "sc/remove-from-wishlist.html" + "?" + Constants.REQUEST_PARAM_PRODUCT_SKU_CODE + "=" + skuCode.toLowerCase();
	}
	
	// CART

	public String buildCartDetailsUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer) {
		return buildCartDetailsUrl(request, marketPlace, market,  marketArea, localization, retailer, true);
	}
	
	public String buildCartDetailsUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer, final boolean keepCurrentDomainName) {
		return getFullPrefixUrl(request, marketPlace, market, marketArea, localization, retailer, keepCurrentDomainName)  +  getMessage(localization, "seo.url.shoppingcart")  + "/" + "cart-details.html";
	}

	public String buildCartDetailsUpdateUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer) {
		return buildCartDetailsUpdateUrl(request, marketPlace, market,  marketArea, localization, retailer, true);
	}
	
	public String buildCartDetailsUpdateUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer, final boolean keepCurrentDomainName) {
		return getFullPrefixUrl(request, marketPlace, market, marketArea, localization, retailer, keepCurrentDomainName)  +  getMessage(localization, "seo.url.shoppingcart")  + "/" + "cart-details-update.html";
	}
	
	public String buildCartAuthUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer) {
		return buildCartAuthUrl(request, marketPlace, market,  marketArea, localization, retailer, true);
	}
	
	public String buildCartAuthUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer, final boolean keepCurrentDomainName) {
		return getFullPrefixUrl(request, marketPlace, market, marketArea, localization, retailer, keepCurrentDomainName)  +  getMessage(localization, "seo.url.shoppingcart")  + "/" + "cart-auth.html";
	}

	public String buildCartDeliveryAndOrderDetailsUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer) {
		return buildCartDeliveryAndOrderDetailsUrl(request, marketPlace, market,  marketArea, localization, retailer, true);
	}
	
	public String buildCartDeliveryAndOrderDetailsUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer, final boolean keepCurrentDomainName) {
		return getFullPrefixUrl(request, marketPlace, market, marketArea, localization, retailer, keepCurrentDomainName)  +  getMessage(localization, "seo.url.shoppingcart")  + "/" + "cart-delivery-order-information.html";
	}

	public String buildCartOrderPaymentUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer) {
		return buildCartOrderPaymentUrl(request, marketPlace, market,  marketArea, localization, retailer, true);
	}
	
	public String buildCartOrderPaymentUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer, final boolean keepCurrentDomainName) {
		return getFullPrefixUrl(request, marketPlace, market, marketArea, localization, retailer, keepCurrentDomainName)  +  getMessage(localization, "seo.url.shoppingcart")  + "/" + "cart-order-payment.html";
	}

	public String buildCartOrderConfirmationUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer) {
		return buildCartOrderConfirmationUrl(request, marketPlace, market,  marketArea, localization, retailer, true);
	}
	
	public String buildCartOrderConfirmationUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer, final boolean keepCurrentDomainName) {
		return getFullPrefixUrl(request, marketPlace, market, marketArea, localization, retailer, keepCurrentDomainName)  +  getMessage(localization, "seo.url.shoppingcart")  + "/" + "cart-order-confirmation.html";
	}
	
	// CUSTOMER
	
	public String buildCustomerDetailsUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer) {
		return buildCustomerDetailsUrl(request, marketPlace, market,  marketArea, localization, retailer, true);
	}
	
	public String buildCustomerDetailsUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer, final boolean keepCurrentDomainName) {
		return getFullPrefixUrl(request, marketPlace, market, marketArea, localization, retailer, keepCurrentDomainName)  +  getMessage(localization, "seo.url.customer")  + "/" + "customer-details.html";
	}
	
	public String buildCustomerOrderListUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer) {
		return buildCustomerOrderListUrl(request, marketPlace, market,  marketArea, localization, retailer, true);
	}
	
	public String buildCustomerOrderListUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer, final boolean keepCurrentDomainName) {
		return getFullPrefixUrl(request, marketPlace, market, marketArea, localization, retailer, keepCurrentDomainName)  +  getMessage(localization, "seo.url.customer")  + "/" + "customer-order-list.html";
	}
	
	public String buildCustomerOrderDetailsUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer, final String orderId) {
		return buildCustomerOrderDetailsUrl(request, marketPlace, market,  marketArea, localization, retailer, orderId, true);
	}
	
	public String buildCustomerOrderDetailsUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer, final String orderId, final boolean keepCurrentDomainName) {
		return getContextPrefixUrl(request, marketArea) + "sc/customer-order-details.html?" + Constants.REQUEST_PARAM_CUSTOMER_ORDER_ID + "=" + orderId;
	}

	public String buildCustomerWishlistUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer) {
		return buildCustomerWishlistUrl(request, marketPlace, market,  marketArea, localization, retailer, true);
	}
	
	public String buildCustomerWishlistUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer, final boolean keepCurrentDomainName) {
		return getFullPrefixUrl(request, marketPlace, market, marketArea, localization, retailer, keepCurrentDomainName)  +  getMessage(localization, "seo.url.customer")  + "/" + "customer-wishlist.html";
	}
	
	public String buildCustomerCreateAccountUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer) {
		return buildCustomerCreateAccountUrl(request, marketPlace, market,  marketArea, localization, retailer, true);
	}
	
	public String buildCustomerCreateAccountUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer, final boolean keepCurrentDomainName) {
		return getFullPrefixUrl(request, marketPlace, market, marketArea, localization, retailer, keepCurrentDomainName)  +  getMessage(localization, "seo.url.customer")  + "/" + "customer-create-account.html";
	}
	
	public String buildCustomerAddressListUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer) {
		return buildCustomerAddressListUrl(request, marketPlace, market,  marketArea, localization, retailer, true);
	}
	
	public String buildCustomerAddressListUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer, final boolean keepCurrentDomainName) {
		return getFullPrefixUrl(request, marketPlace, market, marketArea, localization, retailer, keepCurrentDomainName)  +  getMessage(localization, "seo.url.customer")  + "/" + "customer-address-list.html";
	}
	
	public String buildCustomerAddAddressUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer) {
		return buildCustomerAddAddressUrl(request, marketPlace, market,  marketArea, localization, retailer, true);
	}
	
	public String buildCustomerAddAddressUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer, final boolean keepCurrentDomainName) {
		return getFullPrefixUrl(request, marketPlace, market, marketArea, localization, retailer, keepCurrentDomainName)  +  getMessage(localization, "seo.url.customer")  + "/" + "customer-add-address.html";
	}
	
	public String buildCustomerEditAddressUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer, final String customerAddressId) {
		return getContextPrefixUrl(request, marketArea) + "sc/customer-edit-address.html?" + Constants.REQUEST_PARAM_CUSTOMER_ADDRESS_ID + "=" + customerAddressId;
	}
	
	public String buildCustomerDeleteAddressUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer, final String customerAddressId) {
		return getContextPrefixUrl(request, marketArea) + "sc/customer-delete-address.html?" + Constants.REQUEST_PARAM_CUSTOMER_ADDRESS_ID + "=" + customerAddressId;
	}
	
	// SECURITY
	
	public String buildLoginUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer) {
		return getContextPrefixUrl(request, marketArea) + "sc/login.html";
	}
	
	public String buildLoginSuccesUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer) {
		return buildHomeUrl(request, marketPlace, market, marketArea, localization, retailer);
	}

	public String buildLogoutUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer) {
		return getContextPrefixUrl(request, marketArea) + "sc/logout-session.html";
	}
	
	public String buildForbiddenUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer) {
		return getContextPrefixUrl(request, marketArea) + "sc/forbidden.html";
	}

	public String buildTimeoutUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer) {
		return getFullPrefixUrl(request, marketPlace, market, marketArea, localization, retailer) +  getMessage(localization, "seo.url.timeout")  + "/" + "timeout.html";
	}
	
	public String buildForgottenPasswordUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer) {
		return getFullPrefixUrl(request, marketPlace, market, marketArea, localization, retailer) +  getMessage(localization, "seo.url.forgotten.password")  + "/" + "forgotten-password.html";
	}

	public String buildSpringSecurityCheckUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer) {
		return getContextPrefixUrl(request, marketArea) + "" +  "j_spring_security_check";
	}

	protected String getFullPrefixUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer) {
		return getFullPrefixUrl(request, marketPlace, market,  marketArea, localization, retailer, true);
	}
	
	protected String getFullPrefixUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer, boolean keepCurrentDomainName) {
		String fullPrefixUrl = getBasicPrefixUrl(request, marketPlace, market, marketArea, localization, retailer, keepCurrentDomainName) + getSiteDefaultPrefixUrl(localization) + "/";
		return fullPrefixUrl;
	}
	
	protected String getBasicPrefixUrl(final HttpServletRequest request, final MarketPlace marketPlace, final Market market, final MarketArea marketArea, final Localization localization, final Retailer retailer, boolean keepCurrentDomainName) {
		String basicPrefixUrl = getContextPrefixUrl(request, marketArea, keepCurrentDomainName) + getMarketPlacePrefixUrl(marketPlace) + getMarketPrefixUrl(market) + getMarketModePrefixUrl(marketArea) + getLocalizationPrefixUrl(localization) + getRetailerPrefixUrl(retailer);
		return basicPrefixUrl;
	}

	protected String getContextPrefixUrl(final HttpServletRequest request, final MarketArea marketArea) {
		return getContextPrefixUrl(request,  marketArea, true);
	}

	protected String getContextPrefixUrl(final HttpServletRequest request, final MarketArea marketArea, boolean keepCurrentDomainName) {
		String contextPrefixUrl = "";
		if(BooleanUtils.negate(keepCurrentDomainName)){
			if(request.getRequestURL().toString().contains("localhost")
					|| request.getRequestURL().toString().contains("127.0.0.1")) {
				String domainName = "localhost:18080/fo-mcommerce";
				contextPrefixUrl = "http://"+ domainName + "/";
			} else {
				String domainName = marketArea.getDomainName();
				contextPrefixUrl = "http://"+ domainName + "/";
			}
		} else {
			if(request.getRequestURL().toString().contains("localhost")
					|| request.getRequestURL().toString().contains("127.0.0.1")) {
				contextPrefixUrl = contextPrefixUrl + request.getContextPath() + "/";
			} else {
				contextPrefixUrl = "/";
			}
		}
		return contextPrefixUrl;
	}
	
	protected String getMarketPlacePrefixUrl(final MarketPlace marketPlace) {
		String marketPlacePrefixUrl = marketPlace.getCode().toLowerCase() + "/";
		return marketPlacePrefixUrl;
	}
	
	protected String getMarketPrefixUrl(final Market market) {
		String marketPrefixUrl = market.getCode().toLowerCase() + "/";
		return marketPrefixUrl;
	}
	
	protected String getMarketModePrefixUrl(final MarketArea marketArea) {
		String marketAreaPrefixUrl = marketArea.getCode().toLowerCase() + "/";
		return marketAreaPrefixUrl;
	}
	
	protected String getLocalizationPrefixUrl(final Localization localization) {
		String localizationPrefixUrl = localization.getLocaleCode().toLowerCase() + "/";
		return localizationPrefixUrl;
	}
	
	protected String getRetailerPrefixUrl(final Retailer retailer) {
		String retailerPrefixUrl = retailer.getCode().toLowerCase() + "/";
		return retailerPrefixUrl;
	}
	
	protected String handleString(String string) {
		String stringToReturn = string;
		if(StringUtils.isNotEmpty(stringToReturn)) {
			stringToReturn = stringToReturn.replace(" ", "-");
			stringToReturn = stringToReturn.replaceAll("[àáâãäå]", "a");
			stringToReturn = stringToReturn.replaceAll("[ç]", "c");
			stringToReturn = stringToReturn.replaceAll("[èéêë]", "e");
			stringToReturn = stringToReturn.replaceAll("[ìíîï]", "i");
			stringToReturn = stringToReturn.replaceAll("[ðòóôõö]", "o");
			stringToReturn = stringToReturn.replaceAll("[ùúûü]", "u");
			stringToReturn = stringToReturn.replaceAll("[ýÿ]", "y");
			return stringToReturn.toLowerCase().trim();
		}
		return stringToReturn;
	}
	
	protected String getMessage(final Localization localization, final String key) {
		final Locale locale = localization.getLocale();
		return handleString(coreMessageSource.getMessage(key, null, locale));
	}
	
	protected MessageSource getMessageSource() {
		return coreMessageSource;
	}
	
	protected String getSiteDefaultPrefixUrl(final Localization localization) {
		final Locale locale = localization.getLocale();
		String seoUrl = handleString(coreMessageSource.getMessage("seo.url.main", null, locale));
		if(StringUtils.isNotEmpty(seoUrl)){
			seoUrl = seoUrl.replace(" ", "-");
		}
		return seoUrl;
	}
	
}