// パッケージ名。
package com.manage.library.dao;

//必要なライブラリをインポート。
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

//dbとの実際のやり取りの詳細を記述する、Dao継承クラス。
public class BooksJoinLendingsAndUsersDaoImpl extends JdbcDaoSupport implements BooksJoinLendingsAndUsersDao {

  // 継承した抽象メソッドをオーバーライドし、具体的な内容を記述。
  public List<BooksJoinLendingsAndUsers> findAll() throws DataAccessException {

    // 結合したテーブルのモデル型でできたrowmapperを生成する。
    RowMapper<BooksJoinLendingsAndUsers> rowMapper = new HomeListRowMapper();
    // sql文の結果をテンプレートで返す。
    return getJdbcTemplate().query(
        "select * from books left outer join users on user_id = owner_user_id inner join lendings on books.book_id = lendings.book_id;",
        rowMapper);
  }

  // 継承した抽象メソッドをオーバーライドし、具体的な内容を記述。
  public List<BooksJoinLendingsAndUsers> findFromId(int id) {
    // 結合したテーブルのモデル型でできたrowmapperを生成する。
    RowMapper<BooksJoinLendingsAndUsers> rowMapper = new HomeListRowMapper();
    // sql文の結果をテンプレートで返す。
    return getJdbcTemplate().query(
        "select * from books left outer join users on user_id = owner_user_id inner join lendings on books.book_id = lendings.book_id where books.book_id="
            + id + ";",
        rowMapper);
  }

  protected class HomeListRowMapper implements RowMapper<BooksJoinLendingsAndUsers> {

    // 結合したテーブルのモデル型でできたbookListを生成する。
    private List<BooksJoinLendingsAndUsers> bookList = new ArrayList<BooksJoinLendingsAndUsers>();

    public List<BooksJoinLendingsAndUsers> getResults() {
      return bookList;
    }

    // モデルクラスのsetterメソッドを用いて、dbから得たデータを各カラムに格納する。
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
      // データが格納されたviewObjを返す。
      return viewObj;
    }
  }

}