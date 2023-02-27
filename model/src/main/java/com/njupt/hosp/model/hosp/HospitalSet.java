package com.njupt.hosp.model.hosp;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.njupt.hosp.model.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * (HospitalSet)实体类
 *
 * @author makejava
 * @since 2023-02-27 12:43:59
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("hospital_set")
public class HospitalSet extends BaseEntity {
    private static final long serialVersionUID = -71408555140723644L;

    @ApiModelProperty(value = "医院名称")
    @TableField("hosname")
    private String hosname;

    @ApiModelProperty(value = "医院编号")
    @TableField("hoscode")
    private String hoscode;

    @ApiModelProperty(value = "api基础路径")
    @TableField("api_url")
    private String apiUrl;

    @ApiModelProperty(value = "签名密钥")
    @TableField("sign_key")
    private String signKey;

    @ApiModelProperty(value = "联系人")
    @TableField("contacts_name")
    private String contactsName;

    @ApiModelProperty(value = "联系电话")
    @TableField("contacts_phone")
    private String contactsPhone;

    @ApiModelProperty(value = "状态")
    @TableField("status")
    private Integer status;

}

