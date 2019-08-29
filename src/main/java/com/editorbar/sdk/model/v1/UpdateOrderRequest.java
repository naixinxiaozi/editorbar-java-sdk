package com.editorbar.sdk.model.v1;

import com.editorbar.sdk.HttpRequest;
import com.editorbar.sdk.Method;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UpdateOrderRequest extends HttpRequest<UpdateOrderResponse> {

    public static final String PATH = "/orders/update";
    /**
     * 用户标识， 用来区别不同的用户
     * 需要唯一性（例如数据库用户主键ID, 或者唯一登录名）
     */
    @SerializedName("identifier")
    @Expose
    private String identifier;

    /**
     * 订单ID
     */
    @SerializedName("id")
    @Expose
    private Long id;

    /**
     * 研究领域ID
     */
    @SerializedName("fieldId")
    @Expose
    private Long fieldId;

    /**
     * 润色类型： 0-深度润色， 1-高端润色， 2-双重润色， 3-官方润色，4-论文翻译 8-专家润色
     */
    @SerializedName("type")
    @Expose
    private Integer type;

    /**
     * 稿件状态(0:投稿前润色 1:投稿返修润色 2:其它)
     */
    @SerializedName("state")
    @Expose
    private Integer state = 0;

    /**
     * 稿件题目
     */
    @SerializedName("title")
    @Expose
    private String title;

    /**
     * 稿件摘要
     */
    @SerializedName("abstracts")
    @Expose
    private String abstracts;

    /**
     * 通讯作者
     */
    @SerializedName("author")
    @Expose
    private String author;

    /**
     * 论文专业
     */
    @SerializedName("major")
    @Expose
    private String major;

    /**
     * 拟投期刊
     */
    @SerializedName("journal")
    @Expose
    private String journal;

    /**
     * 致客服的重要信息
     */
    @SerializedName("messageToStaff")
    @Expose
    private String messageToStaff;

    /**
     * 用户上传附件
     */
    @SerializedName("manuscriptAttachmentUrl")
    @Expose
    private String manuscriptAttachmentUrl;

    /**
     * 是否需要发票
     */
    @SerializedName("needInvoice")
    @Expose
    private Boolean needInvoice;

    /**
     * 用户填写的发票信息
     */
    @SerializedName("invoice")
    @Expose
    private InvoiceRequest invoice;


    public UpdateOrderRequest(String identifier) {
        super(PATH, Method.POST);
        if (identifier == null || identifier.isEmpty()) {
            throw new IllegalArgumentException("identifier can't be empty");
        }
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getFieldId() {
        return fieldId;
    }

    public void setFieldId(Long fieldId) {
        this.fieldId = fieldId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbstracts() {
        return abstracts;
    }

    public void setAbstracts(String abstracts) {
        this.abstracts = abstracts;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public String getMessageToStaff() {
        return messageToStaff;
    }

    public void setMessageToStaff(String messageToStaff) {
        this.messageToStaff = messageToStaff;
    }

    public String getManuscriptAttachmentUrl() {
        return manuscriptAttachmentUrl;
    }

    public void setManuscriptAttachmentUrl(String manuscriptAttachmentUrl) {
        this.manuscriptAttachmentUrl = manuscriptAttachmentUrl;
    }

    public Boolean getNeedInvoice() {
        return needInvoice;
    }

    public void setNeedInvoice(Boolean needInvoice) {
        this.needInvoice = needInvoice;
    }

    public InvoiceRequest getInvoice() {
        return invoice;
    }

    public void setInvoice(InvoiceRequest invoice) {
        this.invoice = invoice;
    }

    @Override
    public Class<UpdateOrderResponse> getResponseClass() {
        return UpdateOrderResponse.class;
    }


    public static class InvoiceRequest {
        /**
         * 发票ID
         */
        @SerializedName("id")
        @Expose
        private Long id;

        /**
         * 发票类型： 0-电子发票
         */
        @SerializedName("type")
        @Expose
        private Integer type;
        /**
         * 发票单位
         */
        @SerializedName("name")
        @Expose
        private String name;
        /**
         * 税号
         */
        @SerializedName("taxCode")
        @Expose
        private String taxCode;
        /**
         * 发票内容： 0-论文编辑费， 1-论文润色费， 2-论文润色费， 3-翻译费， 4-版面费， 5-编辑费， 6-技术服务费
         */
        @SerializedName("content")
        @Expose
        private Integer content;
        /**
         * 联系电话
         */
        @SerializedName("phone")
        @Expose
        private String phone;
        /**
         * 联系邮箱
         */
        @SerializedName("email")
        @Expose
        private String email;
        /**
         * 备注
         */
        @SerializedName("description")
        @Expose
        private String description;

        public InvoiceRequest() {
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTaxCode() {
            return taxCode;
        }

        public void setTaxCode(String taxCode) {
            this.taxCode = taxCode;
        }

        public Integer getContent() {
            return content;
        }

        public void setContent(Integer content) {
            this.content = content;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
}
