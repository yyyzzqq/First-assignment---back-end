package com.example.contact.controller;

import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.example.contact.domain.base.AjaxResult;
import com.example.contact.domain.base.R;
import com.example.contact.domain.req.ContactListReq;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.contact.domain.Contact;
import com.example.contact.service.IContactService;


/**
 * 联系人Controller
 *
 * @author ruoyi
 * @date 2024-10-26
 */
@RestController
@RequestMapping("/contact")
public class ContactController extends BaseController
{
    @Autowired
    private IContactService contactService;

    /**
     * 查询联系人列表
     */
    
    @GetMapping("/list")
    public R list(ContactListReq contactListReq)
    {
        PageHelper.startPage(contactListReq.getPageNum(), contactListReq.getPageSize());
        Contact contact = new Contact();
        BeanUtils.copyProperties(contactListReq, contact);

        List<Contact> contacts = contactService.selectContactList(contact);
        if (contacts.size() > 0) {
            PageInfo<Contact> pageInfo = new PageInfo<>(contacts);
            return R.ok(pageInfo);
        }
        return R.ok(new PageInfo<Contact>(Collections.emptyList()));
    }

 
    /**
     * 获取联系人详细信息
     */
    
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(contactService.selectContactById(id));
    }

    /**
     * 新增联系人
     */
    
   
    @PostMapping
    public AjaxResult add(@RequestBody Contact contact)
    {
        return toAjax(contactService.insertContact(contact));
    }

    /**
     * 修改联系人
     */
    
   
    @PutMapping
    public AjaxResult edit(@RequestBody Contact contact)
    {
        return toAjax(contactService.updateContact(contact));
    }

    /**
     * 删除联系人
     */
    
   
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(contactService.deleteContactByIds(ids));
    }
}
