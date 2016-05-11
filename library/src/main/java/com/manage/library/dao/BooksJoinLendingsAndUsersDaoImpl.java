// �p�b�P�[�W���B
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

//db�Ƃ̎��ۂ̂����̏ڍׂ��L�q����ADao�p���N���X�B
public class BooksJoinLendingsAndUsersDaoImpl extends JdbcDaoSupport implements BooksJoinLendingsAndUsersDao {

  // �p���������ۃ��\�b�h���I�[�o�[���C�h���A��̓I�ȓ��e���L�q�B
  public List<BooksJoinLendingsAndUsers> findAll() throws DataAccessException {

    // ���������e�[�u���̃��f���^�łł���rowmapper�𐶐�����B
    RowMapper<BooksJoinLendingsAndUsers> rowMapper = new HomeListRowMapper();
    // sql���̌��ʂ��e���v���[�g�ŕԂ��B
    return getJdbcTemplate().query(
        "select * from books left outer join users on user_id = owner_user_id inner join lendings on books.book_id = lendings.book_id;",
        rowMapper);
  }

  // �p���������ۃ��\�b�h���I�[�o�[���C�h���A��̓I�ȓ��e���L�q�B
  public List<BooksJoinLendingsAndUsers> findFromId(int id) {
    // ���������e�[�u���̃��f���^�łł���rowmapper�𐶐�����B
    RowMapper<BooksJoinLendingsAndUsers> rowMapper = new HomeListRowMapper();
    // sql���̌��ʂ��e���v���[�g�ŕԂ��B
    return getJdbcTemplate().query(
        "select * from books left outer join users on user_id = owner_user_id inner join lendings on books.book_id = lendings.book_id where books.book_id="
            + id + ";",
        rowMapper);
  }

  protected class HomeListRowMapper implements RowMapper<BooksJoinLendingsAndUsers> {

    // ���������e�[�u���̃��f���^�łł���bookList�𐶐�����B
    private List<BooksJoinLendingsAndUsers> bookList = new ArrayList<BooksJoinLendingsAndUsers>();

    public List<BooksJoinLendingsAndUsers> getResults() {
      return bookList;
    }

    // ���f���N���X��setter���\�b�h��p���āAdb���瓾���f�[�^���e�J�����Ɋi�[����B
    public BooksJoinLendingsAndUsers mapRow(ResultSet rs, int rowNum) throws SQLException {
      BooksJoinLendingsAndUsers viewObj = new BooksJoinLendingsAndUsers();

      Books books = new Books();
      Lendings lendings = new Lendings();
      Users users = new Users();

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

      viewObj.setBooks(books);
      viewObj.setLendings(lendings);
      viewObj.setUsers(users);
      // �f�[�^���i�[���ꂽviewObj��Ԃ��B
      return viewObj;
    }
  }

}