package com.gov.uae.axiom.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.gov.uae.axiom.domain.Mobiles;
import com.gov.uae.axiom.service.MobileService;

@RestController
@RequestMapping("/mobiles")
public class MobileController {

	private MobileService mobileService;
	
	private static final List<String> validKeys = Arrays.asList("id", "brand", "phone", "picture", "sim", "resolution",
			"announceDate", "priceEur", "audioJack", "gps", "battery");

	public MobileController(MobileService mobileService) {
		this.mobileService = mobileService;
	}

	/**
	 * @return All Saved List from Database
	 */
	@GetMapping("/list")
	public Iterable<Mobiles> list() {
		return mobileService.list();
	}

	/**
	 * @param requestBody
	 * @return list of Mobile
	 */
	@GetMapping("/search")
	public Iterable<Mobiles> search(@RequestParam Map<String, String> requestBody) {
		Map<String, String> mobilesMap = requestBody.entrySet().stream().filter(e -> validKeys.contains(e.getKey()))
				.filter(e -> e.getValue() instanceof String)
				.collect(Collectors.toMap(Map.Entry::getKey, e -> ((String) e.getValue())));
		String id = getValueByParameterName(mobilesMap, "id");
		String brand = getValueByParameterName(mobilesMap, "brand");
		String phone = getValueByParameterName(mobilesMap, "phone");
		String picture = getValueByParameterName(mobilesMap, "picture");
		String sim = getValueByParameterName(mobilesMap, "sim");
		String resolution = getValueByParameterName(mobilesMap, "resolution");
		String announceDate = getValueByParameterName(mobilesMap, "announceDate");
		String priceEur = getValueByParameterName(mobilesMap, "priceEur");
		String audioJack = getValueByParameterName(mobilesMap, "audioJack");
		String gps = getValueByParameterName(mobilesMap, "gps");
		String battery = getValueByParameterName(mobilesMap, "battery");
		return mobileService.searchByoneOrMoreCreiteria((id != null ? Long.valueOf(id) : null) ,
				brand, phone, picture, sim, resolution, announceDate, priceEur, audioJack, gps, battery);
	}

	/**
	 * @param requestBody
	 * @param parameter
	 * @return exact Value of Parameter passed
	 */
	private String  getValueByParameterName(Map<String, String> requestBody, String parameter) {
		if (requestBody.containsKey(parameter)) {
			return Optional.ofNullable(requestBody.get(parameter))
					.filter(n -> n instanceof String).map(n -> (String) n).orElseThrow(IllegalArgumentException::new);
		    } else {
		       return null;
		    }
		}
}
