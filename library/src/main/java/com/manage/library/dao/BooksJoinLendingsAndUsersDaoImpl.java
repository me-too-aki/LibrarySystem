/**
 *  パッケージ名。
 */
package com.manage.library.dao;

/**
 * 必要なライブラリをインポート。
 */
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
 * dbとの実際のやり取りの詳細を記述する、Dao継承クラス。
 */
public class BooksJoinLendingsAndUsersDaoImpl extends JdbcDaoSupport implements BooksJoinLendingsAndUsersDao {

  /**
   * 結合したテーブルから、値を全て取得するメソッド。 継承した抽象メソッドをオーバーライドしている。
   * rowMapperを生成し、sql文の結果を格納してテンプレートで返す。
   * 
   * @return getJdbcTemplate().query(
   *         "select * from books left outer join users on user_id = owner_user_id inner join lendings on books.book_id = lendings.book_id;"
   *         , rowMapper);
   */
  public List<BooksJoinLendingsAndUsers> findAll() throws DataAccessException {

    RowMapper<BooksJoinLendingsAndUsers> rowMapper = new HomeListRowMapper();
    return getJdbcTemplate().query(
        "select * from books left outer join users on user_id = owner_user_id inner join lendings on books.book_id = lendings.book_id;",
        rowMapper);
  }

  /**
   * 結合したテーブルから、対応するレコードを取得するメソッド。 継承した抽象メソッドをオーバーライドしている。
   * rowMapperを生成し、sql文の結果を格納してテンプレートで返す。
   * 
   * @param id
   * @return getJdbcTemplate().query(
   *         "select * from books left outer join users on user_id = owner_user_id inner join lendings on books.book_id = lendings.book_id where books.book_id="
   *         + id + ";", rowMapper);
   */
  public List<BooksJoinLendingsAndUsers> findFromId(int id) {
    RowMapper<BooksJoinLendingsAndUsers> rowMapper = new HomeListRowMapper();
    return getJdbcTemplate().query(
        "select * from books left outer join users on user_id = owner_user_id inner join lendings on books.book_id = lendings.book_id where books.book_id="
            + id + ";",
        rowMapper);
  }

  /**
   * dbからResultSet型で得た値をオブジェクトに落とし込む為のクラス。 RowMapperインターフェースを実装する。
   */
  protected class HomeListRowMapper implements RowMapper<BooksJoinLendingsAndUsers> {

    /**
     * @param bookList 結合したテーブルから取得するリスト。
     */
    private List<BooksJoinLendingsAndUsers> bookList = new ArrayList<BooksJoinLendingsAndUsers>();

    /**
     * 取得したResultsetを、List型で返す為のメソッド。
     * 
     * @return bookList
     */
    public List<BooksJoinLendingsAndUsers> getResults() {
      return bookList;
    }

    /**
     * dbの各カラムから得たデータを、 Books、Lendings、Usersの各モデルクラスのsetterメソッドを用いて
     * 、オブジェクトに格納して返すメソッド。 RowMapperインターフェースのメソッドをオーバーライドしたもので、sql実行時に呼び出される。
     * 
     * @return viewObj 各カラムのデータが格納されたオブジェクト
     */
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
      return viewObj;
    }
  }

}