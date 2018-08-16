package libpackage;
import java.util.ListResourceBundle;
public class LibPrvoiderResourceBundle extends ListResourceBundle
{
  public static String LibraryTimingName= "LibraryTimingName";
  public static String LibraryTimingTitle= "LibraryTimingTitle";
  public static String LibraryTimingDesc= "LibraryTimingDesc";

  public static String NewArrivalBookName= "NewArrivalBookName";
  public static String NewArrivalBookTitle= "NewArrivalBookTitle";
  public static String NewArrivalBookDesc= "NewArrivalBookDesc";

  public static String BorrowedBooksName= "BorrowedBooksName";
  public static String BorrowedBooksTitle= "BorrowedBooksTitle";
  public static String BorrowedBooksDesc= "BorrowedBooksDesc";

  public static String OverDueBookName= "OverDueBookName";
  public static String OverDueBookTitle= "OverDueBookTitle";
  public static String OverDueBookDesc= "OverDueBookDesc";

  public Object[][] getContents()
  {
    return contents;
  }
  static private final Object[][] contents =
  {
    {LibraryTimingName ,"LibraryTiming"},
    {LibraryTimingTitle ,"Library Timing"},
    {LibraryTimingDesc ,"Library Timing"},
    {NewArrivalBookName ,"NewArrivalBooks"},
    {NewArrivalBookTitle ,"Newly Arrived Books"},
    {NewArrivalBookDesc ,"Newly Arrived Books"},
    {BorrowedBooksName ,"NoOfBorrowedBooks"},
    {BorrowedBooksTitle ,"Borrowed Books"},
    {BorrowedBooksDesc ,"Number of Borrowed Books"},
    {OverDueBookName ,"OverdueBooks"},
    {OverDueBookTitle ,"Overdue Books"},
    {OverDueBookDesc ,"Overdue Books"}
  };
}