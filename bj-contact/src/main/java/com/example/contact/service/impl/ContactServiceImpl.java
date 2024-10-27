package com.example.contact.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.contact.mapper.ContactMapper;
import com.example.contact.domain.Contact;
import com.example.contact.service.IContactService;

/**
 * 联系人Service业务层处理
 *
 * @author ruoyi
 * @date 2024-10-26
 */
@Service
public class ContactServiceImpl implements IContactService
{
    @Autowired
    private ContactMapper contactMapper;

    /**
     * 查询联系人
     *
     * @param id 联系人主键
     * @return 联系人
     */
    @Override
    public Contact selectContactById(Long id)
    {
        return contactMapper.selectContactById(id);
    }

    /**
     * 查询联系人列表
     *
     * @param contact 联系人
     * @return 联系人
     */
    @Override
    public List<Contact> selectContactList(Contact contact)
    {
        return contactMapper.selectContactList(contact);
    }

    /**
     * 新增联系人
     *
     * @param contact 联系人
     * @return 结果
     */
    @Override
    public int insertContact(Contact contact)
    {
        contact.setCreateTime(new Date());
        return contactMapper.insertContact(contact);
    }

    /**
     * 修改联系人
     *
     * @param contact 联系人
     * @return 结果
     */
    @Override
    public int updateContact(Contact contact)
    {
        contact.setUpdateTime(new Date());
        return contactMapper.updateContact(contact);
    }

    /**
     * 批量删除联系人
     *
     * @param ids 需要删除的联系人主键
     * @return 结果
     */
    @Override
    public int deleteContactByIds(Long[] ids)
    {
        return contactMapper.deleteContactByIds(ids);
    }

    /**
     * 删除联系人信息
     *
     * @param id 联系人主键
     * @return 结果
     */
    @Override
    public int deleteContactById(Long id)
    {
        return contactMapper.deleteContactById(id);
    }
}
