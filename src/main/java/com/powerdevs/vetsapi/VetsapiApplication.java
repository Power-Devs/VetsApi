package com.powerdevs.vetsapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VetsapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(VetsapiApplication.class, args);
		System.out.println("-------------------------------- O sistema foi carregado --------------------------------");
		System.out.println(
			"		#     # ####### #######  #####           #    ######  ### \n" +
			"		#     # #          #    #     #         # #   #     #  #  \n" +
			"		#     # #          #    #              #   #  #     #  #  \n" +
			"		#     # #####      #     #####  ##### #     # ######   #  \n" +
			" 		 #   #  #          #          #       ####### #        #  \n" +
			" 		  # #   #          #    #     #       #     # #        #  \n" +
			"  		   #    #######    #     #####        #     # #       ### \n" +
			"                                                          \n");
	}
}