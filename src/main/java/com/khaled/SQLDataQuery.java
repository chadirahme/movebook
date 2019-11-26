package com.khaled;

/**
 * Created by chadirahme on 11/25/19.
 */
public class SQLDataQuery {

    public static String insertBook()
    {
        String sql="INSERT INTO p_books " +
                " (\n" +
                "           [bo_code]\n" +
                "           ,[bo_title_ar]\n" +
                "           ,[bo_title_fg]\n" +
                "           ,[bo_subtitle1_ar]\n" +
                "           ,[bo_subtitle1_fg]\n" +
                "           ,[bo_subtitle2_ar]\n" +
                "           ,[bo_subtitle2_fg]\n" +
                "           ,[bo_desc]\n" +
                "           ,[bo_isbn]\n" +
                "           ,[bo_barcode]\n" +
                "           ,[bo_nb_pages]\n" +
                "           ,[bo_nb_mal]\n" +
                "           ,[bo_nb_vol]\n" +
                "           ,[bo_price_sal]\n" +
                "           ,[bo_price_pur]\n" +
                "           ,[bo_cost]\n" +
                "           ,[bo_discount]\n" +
                "           ,[bo_allowed]\n" +
                "           ,[bo_paint_title]\n" +
                "           ,[bo_remarks]\n" +
                "           ,[bo_char_id]\n" +
                "           ,[bo_char_desc]\n" +
                "           ,[bo_nb_cart]\n" +
                "           ,[bo_col_id]\n" +
                "           ,[bo_col_desc]\n" +
                "           ,[bo_size_id]\n" +
                "           ,[bo_size_desc]\n" +
                "           ,[bo_weight]\n" +
                "           ,[bo_lg_id]\n" +
                "           ,[bo_lg_desc]\n" +
                "           ,[bo_sub_id]\n" +
                "           ,[bo_sub_desc]\n" +
                "           ,[bo_rel_id]\n" +
                "           ,[bo_rel_desc]\n" +
                "           ,[bo_pap_id]\n" +
                "           ,[bo_pap_desc]\n" +
                "           ,[bo_cov_id]\n" +
                "           ,[bo_cov_desc]\n" +
                "           ,[bo_stk_qty]\n" +
                "           ,[bo_dt_stk_entry]\n" +
                "           ,[bo_img]\n" +
                "           ,[bo_editor_id]\n" +
                "           ,[bo_editor_desc]\n" +
                "           ,[bo_mmm_id]\n" +
                "           ,[bo_mmm_desc]\n" +
                "           ,[bo_min_stock]\n" +
                "           ,[bo_price_sal_2]\n" +
                "           ,[bo_is_print]\n" +
                "           ,[bo_print_year]\n" +
                "           ,[bo_com_id]\n" +
                "           ,[bo_old_id]\n" +
                "           ,[bo_location1]\n" +
                "           ,[bo_location2])\n" +
                "     select \n" +
                "     [bo_code]\n" +
                "           ,[bo_title_ar]\n" +
                "           ,[bo_title_fg]\n" +
                "           ,[bo_subtitle1_ar]\n" +
                "           ,[bo_subtitle1_fg]\n" +
                "           ,[bo_subtitle2_ar]\n" +
                "           ,[bo_subtitle2_fg]\n" +
                "           ,[bo_desc]\n" +
                "           ,[bo_isbn]\n" +
                "           ,[bo_barcode]\n" +
                "           ,[bo_nb_pages]\n" +
                "           ,[bo_nb_mal]\n" +
                "           ,[bo_nb_vol]\n" +
                "           ,[bo_price_sal]\n" +
                "           ,[bo_price_pur]\n" +
                "           ,[bo_cost]\n" +
                "           ,[bo_discount]\n" +
                "           ,[bo_allowed]\n" +
                "           ,[bo_paint_title]\n" +
                "           ,[bo_remarks]\n" +
                "           ,[bo_char_id]\n" +
                "           ,[bo_char_desc]\n" +
                "           ,[bo_nb_cart]\n" +
                "           ,[bo_col_id]\n" +
                "           ,[bo_col_desc]\n" +
                "           ,[bo_size_id]\n" +
                "           ,[bo_size_desc]\n" +
                "           ,[bo_weight]\n" +
                "           ,[bo_lg_id]\n" +
                "           ,[bo_lg_desc]\n" +
                "           ,[bo_sub_id]\n" +
                "           ,[bo_sub_desc]\n" +
                "           ,[bo_rel_id]\n" +
                "           ,[bo_rel_desc]\n" +
                "           ,[bo_pap_id]\n" +
                "           ,[bo_pap_desc]\n" +
                "           ,[bo_cov_id]\n" +
                "           ,[bo_cov_desc]\n" +
                "           ,[bo_stk_qty]\n" +
                "           ,[bo_dt_stk_entry]\n" +
                "           ,[bo_img]\n" +
                "           ,[bo_editor_id]\n" +
                "           ,[bo_editor_desc]\n" +
                "           ,[bo_mmm_id]\n" +
                "           ,[bo_mmm_desc]\n" +
                "           ,[bo_min_stock]\n" +
                "           ,[bo_price_sal_2]\n" +
                "           ,[bo_is_print]\n" +
                "           ,[bo_print_year]\n" +
                "           ,[bo_com_id]\n" +
                "           ,[bo_old_id]\n" +
                "           ,[bo_location1]\n" +
                "           ,[bo_location2]\n" +
                "      from #temp";

        return sql;
    }
}
