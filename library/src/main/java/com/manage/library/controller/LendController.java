/**
 *  �R���g���[���N���X�̃p�b�P�[�W�B
 */
package com.manage.library.controller;

//�K�v�ȃ��C�u�������C���|�[�g�B
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.manage.library.Books;
import com.manage.library.Users;
import com.manage.library.dao.BooksDao;
import com.manage.library.dao.UsersDao;

/**
 * �}���ݏo��ʂ̃R���g���[���N���X�B
 */
@Controller
public class LendController {

    @Autowired
    private BooksDao booksDaoView; // db����books�e�[�u���̃��R�[�h�������Ă���ׂ̃I�u�W�F�N�g�B
    @Autowired
    private UsersDao usersDaoView; // db����users�e�[�u���̃��R�[�h�������Ă���ׂ̃I�u�W�F�N�g�B

    /**
     * �}���ݏo��ʂ�\�����郁�\�b�h�Blend�ւ�GET���N�G�X�g���������Ɏ��s�����B
     * �O��ʂ��瑗����bookId�ɂ���āA�\���������e��ς���B
     *
     * @return lend �}���ݏo���
     */
    @RequestMapping(value = "lend/{bookId}", method = RequestMethod.GET)
    public String lend(@PathVariable("bookId") int id, Locale locale, Model model) {

        // �ݏo��ʂ̕\���ɕK�v�ȃf�[�^�𓾂�ׁAdb��books�e�[�u������Aid�ɑΉ����郌�R�[�h���擾����B
        Books lendBookDetailRecord = booksDaoView.findFromBookId(id);
        // �擾�����f�[�^����ʂɕ\������ׁAlendBookDetail�Ƃ������O��model�ɐݒ肷��B
        model.addAttribute("lendBookDetail", lendBookDetailRecord);

        // �ݏo��ʂ̕\���ɕK�v�ȃf�[�^�𓾂�ׁAdb��users�e�[�u������f�[�^��S�Ď擾����B
        List<Users> UsersList = usersDaoView.findAll();
        // �擾�����f�[�^����ʂɕ\������ׁAusers�Ƃ������O��model�ɐݒ肷��B
        model.addAttribute("users", UsersList);

        // �ݏo��ʂ̕\���ɕK�v�ȃf�[�^�𓾂�ׁAdb��users�e�[�u������A
        // �{���L�҂�id�ɑΉ����郆�[�U�����擾����B
        String ownerUserName = usersDaoView.findUserNameFromUserId(lendBookDetailRecord.getOwnerUserId());
        // �擾�����f�[�^����ʂɕ\������ׁAownerUserName�Ƃ������O��model�ɐݒ肷��B
        model.addAttribute("ownerUserName", ownerUserName);

        // ���t�̃t�H�[�}�b�g�B
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        // ���݂̓��t���擾����ׂ̃I�u�W�F�N�g�B
        Calendar lendDate = Calendar.getInstance();
        // �ԋp�\����̃f�t�H���g�l�Ƃ��āA7����̓��t���擾����ׂ̃I�u�W�F�N�g�B
        Calendar dueDate = Calendar.getInstance();
        // 7��������B
        dueDate.add(Calendar.DAY_OF_MONTH, 7);
        // ���ݓ��t���t�H�[�}�b�g�ŕϊ��������̂��AlendDate�Ƃ������O��model�ɐݒ肷��B
        model.addAttribute("lendDate", df.format(lendDate.getTime()));
        // 7����̓��t���t�H�[�}�b�g�ŕϊ��������̂��AdueDate�Ƃ������O��model�ɐݒ肷��B
        model.addAttribute("dueDate", df.format(dueDate.getTime()));

        // lend.jsp���\�������B
        return "lend";
    }
}
