package com.recommendation.factories;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recommendation.model.SectorType;
import com.recommendation.service.DatabaseService;

public class Factory {
	public static RecommendStocks getCalculator (String sector) {
		switch(sector){
		case "AUTO":
			return new AutoFactory();
		case "CEMENTS":
			return new CementsFactory();
		case "CIGARETTE":
			return new CigaretteFactory();
		case "CONSTRUCTION":
			return new ConstructionFactory();
		case "CONSUMER":
			return new ConsumerFactory();
		case "ENERGY":
			return new EnergyFactory();
		case "FINANCE":
			return new FinanceFactory();
		case "IT":
			return new ITFactory();
		case "MEDIA":
			return new MediaFactory();
		case "METALS":
			return new MetalsFactory();
		case "MANUFACTURING":
			return new ManufacturingFactory();
		case "PHARMA":
			return new PharmaFactory();
		case "SHIPPING":
			return new ShippingFactory();
		case "TELECOM":
			return new TelecomFactory();
		default:
			return null;
		}
	}
}
