package jat.vijesh.ecommerceapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MayntraModel {

    @SerializedName("discount")
    @Expose
    private Integer discount;
    @SerializedName("brands_filter_facet")
    @Expose
    private String brandsFilterFacet;
    @SerializedName("search_image")
    @Expose
    private String searchImage;
    @SerializedName("discounted_price")
    @Expose
    private Integer discountedPrice;
    @SerializedName("gender_from_cms")
    @Expose
    private String genderFromCms;
    @SerializedName("score")
    @Expose
    private Integer score;
    @SerializedName("sizes")
    @Expose
    private String sizes;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("product_additional_info")
    @Expose
    private String productAdditionalInfo;
    @SerializedName("stylename")
    @Expose
    private String stylename;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("product")
    @Expose
    private String product;
    @SerializedName("dre_landing_page_url")
    @Expose
    private String dreLandingPageUrl;
    @SerializedName("global_attr_article_type")
    @Expose
    private String globalAttrArticleType;
    @SerializedName("global_attr_brand")
    @Expose
    private String globalAttrBrand;
    @SerializedName("image_entries")
    @Expose
    private List<String> imageEntries = null;
    @SerializedName("global_attr_base_colour")
    @Expose
    private String globalAttrBaseColour;
    @SerializedName("loyaltyPointsEnabled")
    @Expose
    private Boolean loyaltyPointsEnabled;
    @SerializedName("imageEntry_default")
    @Expose
    private String imageEntryDefault;
    @SerializedName("colour_variant")
    @Expose
    private Boolean colourVariant;
    @SerializedName("style_store8_male_sort_field")
    @Expose
    private Integer styleStore8MaleSortField;
    @SerializedName("styleid")
    @Expose
    private Integer styleid;
    @SerializedName("allSkuForSizes")
    @Expose
    private List<String> allSkuForSizes = null;
    @SerializedName("global_attr_colour1")
    @Expose
    private String globalAttrColour1;
    @SerializedName("dre_discount_label")
    @Expose
    private String dreDiscountLabel;
    @SerializedName("discount_label")
    @Expose
    private String discountLabel;

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public String getBrandsFilterFacet() {
        return brandsFilterFacet;
    }

    public void setBrandsFilterFacet(String brandsFilterFacet) {
        this.brandsFilterFacet = brandsFilterFacet;
    }

    public String getSearchImage() {
        return searchImage;
    }

    public void setSearchImage(String searchImage) {
        this.searchImage = searchImage;
    }

    public Integer getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(Integer discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public String getGenderFromCms() {
        return genderFromCms;
    }

    public void setGenderFromCms(String genderFromCms) {
        this.genderFromCms = genderFromCms;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getSizes() {
        return sizes;
    }

    public void setSizes(String sizes) {
        this.sizes = sizes;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getProductAdditionalInfo() {
        return productAdditionalInfo;
    }

    public void setProductAdditionalInfo(String productAdditionalInfo) {
        this.productAdditionalInfo = productAdditionalInfo;
    }

    public String getStylename() {
        return stylename;
    }

    public void setStylename(String stylename) {
        this.stylename = stylename;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getDreLandingPageUrl() {
        return dreLandingPageUrl;
    }

    public void setDreLandingPageUrl(String dreLandingPageUrl) {
        this.dreLandingPageUrl = dreLandingPageUrl;
    }

    public String getGlobalAttrArticleType() {
        return globalAttrArticleType;
    }

    public void setGlobalAttrArticleType(String globalAttrArticleType) {
        this.globalAttrArticleType = globalAttrArticleType;
    }

    public String getGlobalAttrBrand() {
        return globalAttrBrand;
    }

    public void setGlobalAttrBrand(String globalAttrBrand) {
        this.globalAttrBrand = globalAttrBrand;
    }

    public List<String> getImageEntries() {
        return imageEntries;
    }

    public void setImageEntries(List<String> imageEntries) {
        this.imageEntries = imageEntries;
    }

    public String getGlobalAttrBaseColour() {
        return globalAttrBaseColour;
    }

    public void setGlobalAttrBaseColour(String globalAttrBaseColour) {
        this.globalAttrBaseColour = globalAttrBaseColour;
    }

    public Boolean getLoyaltyPointsEnabled() {
        return loyaltyPointsEnabled;
    }

    public void setLoyaltyPointsEnabled(Boolean loyaltyPointsEnabled) {
        this.loyaltyPointsEnabled = loyaltyPointsEnabled;
    }

    public String getImageEntryDefault() {
        return imageEntryDefault;
    }

    public void setImageEntryDefault(String imageEntryDefault) {
        this.imageEntryDefault = imageEntryDefault;
    }

    public Boolean getColourVariant() {
        return colourVariant;
    }

    public void setColourVariant(Boolean colourVariant) {
        this.colourVariant = colourVariant;
    }

    public Integer getStyleStore8MaleSortField() {
        return styleStore8MaleSortField;
    }

    public void setStyleStore8MaleSortField(Integer styleStore8MaleSortField) {
        this.styleStore8MaleSortField = styleStore8MaleSortField;
    }

    public Integer getStyleid() {
        return styleid;
    }

    public void setStyleid(Integer styleid) {
        this.styleid = styleid;
    }

    public List<String> getAllSkuForSizes() {
        return allSkuForSizes;
    }

    public void setAllSkuForSizes(List<String> allSkuForSizes) {
        this.allSkuForSizes = allSkuForSizes;
    }

    public String getGlobalAttrColour1() {
        return globalAttrColour1;
    }

    public void setGlobalAttrColour1(String globalAttrColour1) {
        this.globalAttrColour1 = globalAttrColour1;
    }

    public String getDreDiscountLabel() {
        return dreDiscountLabel;
    }

    public void setDreDiscountLabel(String dreDiscountLabel) {
        this.dreDiscountLabel = dreDiscountLabel;
    }

    public String getDiscountLabel() {
        return discountLabel;
    }

    public void setDiscountLabel(String discountLabel) {
        this.discountLabel = discountLabel;
    }

}

/////////