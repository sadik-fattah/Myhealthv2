package com.guercifzone.myhealthv2.Classes;

import java.util.List;
import java.util.Map;

public class Product {
    public String code;
    public List<String> errors;
    public ProductDetails product;

    public static class ProductDetails {
        public String _id;
        public List<String> _keywords;
        public String abbreviated_product_name;
        public String abbreviated_product_name_fr;
        public String abbreviated_product_name_fr_imported;
        public List<String> added_countries_tags;
        public int additives_n;
        public List<String> additives_original_tags;
        public List<String> additives_tags;
        public String allergens;
        public String allergens_from_ingredients;
        public String allergens_from_user;
        public List<String> allergens_hierarchy;
        public String allergens_imported;
        public String allergens_lc;
        public List<String> allergens_tags;
        public List<String> amino_acids_prev_tags;
        public List<String> amino_acids_tags;
        public String brands;
        public String brands_imported;
        public List<String> brands_tags;
        public int carbon_footprint_percent_of_known_ingredients;
        public String categories;
        public List<String> categories_hierarchy;
        public String categories_lc;
        public String categories_old;
        public Map<String, String> categories_properties;
        public List<String> categories_properties_tags;
        public List<String> categories_tags;
        public Map<String, String> category_properties;
        public String checked;
        public List<String> checkers_tags;
        public List<String> ciqual_food_name_tags;
        public List<String> cities_tags;
        public String compared_to_category;
        public int complete;
        public double completeness;
        public String conservation_conditions;
        public String conservation_conditions_fr;
        public String conservation_conditions_fr_imported;
        public List<String> correctors_tags;
        public String countries;
        public String countries_beforescanbot;
        public List<String> countries_hierarchy;
        public String countries_imported;
        public String countries_lc;
        public List<String> countries_tags;
        public int created_t;
        public String creator;
        public String customer_service;
        public String customer_service_fr;
        public String customer_service_fr_imported;
        public List<String> data_quality_bugs_tags;
        public List<String> data_quality_errors_tags;
        public List<String> data_quality_info_tags;
        public List<String> data_quality_tags;
        public List<String> data_quality_warnings_tags;
        public String data_sources;
        public String data_sources_imported;
        public List<String> data_sources_tags;
        public List<String> debug_param_sorted_langs;
        public EcoscoreData ecoscore_data;
        public String expiration_date;
        public String food_groups;
        public List<String> food_groups_tags;
        public String generic_name;
        public String generic_name_de;
        public String generic_name_en;
        public String generic_name_es;
        public String generic_name_fr;
        public String generic_name_fr_imported;
        public String generic_name_zh;
        public String nutriments;

        public static class EcoscoreData {
            public Adjustments adjustments;

            public static class Adjustments {
                public OriginsOfIngredients origins_of_ingredients;

                public static class OriginsOfIngredients {
                    public List<AggregatedOrigin> aggregated_origins;
                    public int epi_score;

                    public static class AggregatedOrigin {
                        public String origin;
                        public int percent;
                    }
                }
            }
        }
    }
}

