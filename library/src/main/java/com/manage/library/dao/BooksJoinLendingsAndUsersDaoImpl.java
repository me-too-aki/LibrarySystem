/**
 *   Dao�̃p�b�P�[�W�B
 */
package com.manage.library.dao;

//�K�v�ȃ��C�u�������C���|�[�g�B
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import com.manage.library.Books;
import com.manage.library.BooksJoinLendingsAndUsers;
import com.manage.library.Lendings;
import com.manage.library.Users;

/**
 * db�́Abooks,lendings,users�����������e�[�u���Ƃ̂������L�ڂ���N���X�B
 */
public class BooksJoinLendingsAndUsersDaoImpl extends JdbcDaoSupport implements BooksJoinLendingsAndUsersDao {

    /**
     * ���������e�[�u������A�l��S�Ď擾���郁�\�b�h�B �p���������ۃ��\�b�h���I�[�o�[���C�h���Ă���B
     *
     * @return books,lendings,users�����������e�[�u���̑S���R�[�h
     */
    public List<BooksJoinLendingsAndUsers> findAll() throws DataAccessException {

        // ���������e�[�u�����f���̗v�f�łł���rowMapper�𐶐�����B
        RowMapper<BooksJoinLendingsAndUsers> rowMapper = new HomeListRowMapper();
        // ���������e�[�u���̃f�[�^�S�Ă��e���v���[�g�ŕԂ��B
        return getJdbcTemplate().query(
                "select * from books left outer join users on user_id = owner_user_id inner join lendings on books.book_id = lendings.book_id;",
                rowMapper);
    }

    /**
     * ���������e�[�u������A�Ή����郌�R�[�h���擾���郁�\�b�h�B �p���������ۃ��\�b�h���I�[�o�[���C�h���Ă���B
     *
     * @param id
     * @return books,lendings,users�����������e�[�u���́Aid�ɑΉ����郌�R�[�h
     */
    public List<BooksJoinLendingsAndUsers> findFromId(int id) {
        // ���������e�[�u�����f���̗v�f�łł���rowMapper�𐶐�����B
        RowMapper<BooksJoinLendingsAndUsers> rowMapper = new HomeListRowMapper();
        // ���������e�[�u���́Aid�ɑΉ����郌�R�[�h���e���v���[�g�ŕԂ��B
        return getJdbcTemplate().query(
                "select * from books left outer join users on user_id = owner_user_id inner join lendings on books.book_id = lendings.book_id where books.book_id="
                + id + ";",
                rowMapper);
    }

    /**
     * db����ResultSet�^�œ����l���I�u�W�F�N�g�ɗ��Ƃ����ވׂ̃N���X�B RowMapper�C���^�[�t�F�[�X����������B
     */
    protected class HomeListRowMapper implements RowMapper<BooksJoinLendingsAndUsers> {

        /**
         * ���ۂɌ��������e�[�u�����瓾���f�[�^���A�I�u�W�F�N�g�Ɋi�[���ĕԂ����\�b�h�B
         *
         * @return viewObj �e�J�����̃f�[�^���i�[���ꂽ�I�u�W�F�N�g
         */
        public BooksJoinLendingsAndUsers mapRow(ResultSet rs, int rowNum) throws SQLException {
            // ���������e�[�u���̃I�u�W�F�N�g�𐶐�����B
            BooksJoinLendingsAndUsers viewObj = new BooksJoinLendingsAndUsers();

            // Books�^�̃I�u�W�F�N�g�𐶐�����B�����Ɋe�J�����̃f�[�^������B
            Books books = new Books();
            // Lendings�^�̃I�u�W�F�N�g�𐶐�����B�����Ɋe�J�����̃f�[�^������B
            Lendings lendings = new Lendings();
            // Users�^�̃I�u�W�F�N�g�𐶐�����B�����Ɋe�J�����̃f�[�^������B
            Users users = new Users();

            // �N���X��setter��p���āA���ꂼ��l������B
            books.setBookId(rs.getInt("books.book_id"));
            books.setBookTitle(rs.getString("books.book_title"));
            books.setWritterName(rs.getString("books.writter_name"));
            books.setPublisher(rs.getString("books.publisher"));
            books.setPublishedAt(rs.getDate("books.published_at"));
            books.setOwnerUserId(rs.getInt("books.owner_user_id"));
            books.setRegisteredAt(rs.getTimestamp("books.registered_at"));
            lendings.setBookId(rs.getInt("lendings.book_id"));
            lendings.setLendingStatus(rs.getBoolean("lendings.lending_status"));
            lendings.setLendedAt(rs.getTimestamp("lendings.lended_at"));
            lendings.setDueDate(rs.getDate("lendings.due_date"));
            lendings.setBorrowUserId(rs.getInt("lendings.borrow_user_id"));
            users.setUserId(rs.getInt("users.user_id"));
            users.setUserName(rs.getString("users.user_name"));

            // ���������e�[�u���̃I�u�W�F�N�g�ɁAbooks�e�[�u���̃f�[�^������B
            viewObj.setBooks(books);
            // ���������e�[�u���̃I�u�W�F�N�g�ɁAlendings�e�[�u���̃f�[�^������B
            viewObj.setLendings(lendings);
            // ���������e�[�u���̃I�u�W�F�N�g�ɁAusers�e�[�u���̃f�[�^������B
            viewObj.setUsers(users);
            // �f�[�^����ꂽ�I�u�W�F�N�g��Ԃ��B
            return viewObj;
        }
    }

}
