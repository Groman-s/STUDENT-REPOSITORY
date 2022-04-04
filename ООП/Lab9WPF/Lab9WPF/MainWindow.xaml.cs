using System.Windows;
using System.Windows.Media;
using System.Windows.Shapes;

namespace Lab9WPF
{
    // static лямбда формы - фасад
    // static формы - крыша
    // не static формы - окно
    // static другого класса - труба
    // не static другого класса - дверь

    public class Goyanov
    {
        public static void DrawPipe()
        {
            Rectangle rectangle = new Rectangle();
            rectangle.Stroke = Brushes.Black;
            rectangle.Fill = Brushes.Peru;
            rectangle.Margin = new Thickness(50, 20, 160, 144);
            MainWindow.mainWindowInstance.bottomHolst.Children.Add(rectangle);
        }

        public void DrawDoor()
        {
            Rectangle rectangle = new Rectangle();
            rectangle.Stroke = Brushes.Black;
            rectangle.Fill = Brushes.Peru;
            rectangle.Margin = new Thickness(130, 130, 60, 10);
            MainWindow.mainWindowInstance.upperHolst.Children.Add(rectangle);
        }
    }
    public partial class MainWindow : Window
    {
        public static MainWindow mainWindowInstance;
        public static Goyanov goyanovInstance;

        public delegate void Draw();
        public Draw draw;
        
        public MainWindow()
        {
            InitializeComponent();
            mainWindowInstance = this;
            goyanovInstance = new Goyanov();
        }

        //================================================================================

        private static void drawFacadeMethod()
        {
            Rectangle rectangle = new Rectangle();
            rectangle.Stroke = Brushes.Black;
            rectangle.Fill = Brushes.Chocolate;
            rectangle.Margin = new Thickness(40, 90, 40, 10);
            mainWindowInstance.bottomHolst.Children.Add(rectangle);
        }
        
        public static void DrawFacade() => drawFacadeMethod(); 
        
        public void DrawWindow()
        {
            Rectangle rectangle = new Rectangle();
            rectangle.Stroke = Brushes.Black;
            rectangle.Fill = Brushes.Gray;
            rectangle.Width = 30;
            rectangle.Height = 30;
            rectangle.Margin = new Thickness(20, 90, 80, 10);
            mainWindowInstance.upperHolst.Children.Add(rectangle);
        }
        
        public static void DrawRoof()
        {
            Polygon triangle = new Polygon();
            triangle.Stroke = Brushes.Black;
            triangle.Fill = Brushes.Maroon;
            Point leftCorner = new Point(30, 90);
            Point upperCorner = new Point(117, 30);
            Point rightCorner = new Point(204, 90);
            PointCollection collection = new PointCollection();
            collection.Add(leftCorner);
            collection.Add(upperCorner);
            collection.Add(rightCorner);
            triangle.Points = collection;
            mainWindowInstance.upperHolst.Children.Add(triangle);
        }
        
        //================================================================================
        
        private void drawButton_Click(object sender, RoutedEventArgs e)
        {
            upperHolst.Children.Clear();
            bottomHolst.Children.Clear();
            if (draw != null) draw();
        }
        
        //================================================================================

        private void drawFacadeCheckBox_Checked(object sender, RoutedEventArgs e)
        {
            if (drawFacadeCheckBox.IsChecked.Value) draw += DrawFacade;
            else draw -= DrawFacade;
        }

        private void drawWindowCheckBox_Checked(object sender, RoutedEventArgs e)
        {
            if (drawWindowCheckBox.IsChecked.Value) draw += DrawWindow;
            else draw -= DrawWindow;
        }

        private void drawDoorCheckBox_Checked(object sender, RoutedEventArgs e)
        {
            if (drawDoorCheckBox.IsChecked.Value) draw += goyanovInstance.DrawDoor;
            else draw -= goyanovInstance.DrawDoor;
        }

        private void drawRoofCheckBox_Checked(object sender, RoutedEventArgs e)
        {
            if (drawRoofCheckBox.IsChecked.Value) draw += DrawRoof;
            else draw -= DrawRoof;
        }

        private void drawTrubaCheckBox_Checked(object sender, RoutedEventArgs e)
        {
            if (drawTrubaCheckBox.IsChecked.Value) draw += Goyanov.DrawPipe;
            else draw -= Goyanov.DrawPipe;
        }
        
        //================================================================================
    }
}
