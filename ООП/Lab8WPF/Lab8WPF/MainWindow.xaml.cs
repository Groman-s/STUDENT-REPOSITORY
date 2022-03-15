using System;
using System.Windows;
using System.Windows.Controls;

namespace Lab8WPF
{
    class Cylinder
    {
        private double height;
        private double radius;

        public double Height
        {
            get => height;
            set => height = value;
        }

        public double Radius
        {
            get => radius;
            set => radius = value;
        }

        public Cylinder(double height, double radius)
        {
            this.height = height;
            this.radius = radius;
        }

        public double Volume => Math.PI * radius * radius * height;

        public bool Valid => radius >= 0 && height >= 0;

        public override string ToString()
        {
            if (!Valid) return "Неверные данные";
            return "Высота: " + height + "\nРадиус основания: " + radius + "\nОбъём: " + Math.Round(Volume, 3);
        }

        public static double operator+ (Cylinder firstCylinder, Cylinder secondCylinder)
        {
            return firstCylinder.radius + secondCylinder.radius;
        }

        public static Cylinder operator* (Cylinder firstCylinder, Cylinder secondCylinder)
        {
            return firstCylinder.Volume > secondCylinder.Volume ? firstCylinder : secondCylinder;
        }

        public static bool operator> (Cylinder firstCylinder, Cylinder secondCylinder)
        {
            return firstCylinder.Volume > secondCylinder.Volume;
        }
        
        public static bool operator< (Cylinder firstCylinder, Cylinder secondCylinder)
        {
            return firstCylinder.Volume < secondCylinder.Volume;
        }
        
        public static Cylinder operator-- (Cylinder cylinder)
        {
            cylinder.radius--;
            cylinder.height--;
            return cylinder;
        }
    }

    public partial class MainWindow : Window
    {
        private Cylinder cyl1 = new Cylinder(0, 0);
        private Cylinder cyl2 = new Cylinder(0,0);
        
        public MainWindow()
        {
            InitializeComponent();
            firstInfoArea.Text = cyl1.ToString();
            secondInfoArea.Text = cyl2.ToString();
        }

        private double validateData(TextBox textBox)
        {
            double value = double.Parse(textBox.Text);
            if (value < 0) throw new Exception();
            return value;
        }
        
        private void firstHeightBox_TextChanged(object sender, TextChangedEventArgs e)
        {
            try
            {
                cyl1.Height = validateData(firstHeightBox);
                cyl1.Radius = validateData(firstRadiusBox);
                firstInfoArea.Text = cyl1.ToString();
            }
            catch (Exception ex)
            {
                firstInfoArea.Text = "Неверные данные";
            }
        }

        private void firstRadiusBox_TextChanged(object sender, TextChangedEventArgs e)
        {
            try
            {
                cyl1.Height = validateData(firstHeightBox);
                cyl1.Radius = validateData(firstRadiusBox);
                firstInfoArea.Text = cyl1.ToString();
            }
            catch (Exception ex)
            {
                firstInfoArea.Text = "Неверные данные";
            }
        }

        private void firstIncrementButton_Click(object sender, RoutedEventArgs e)
        {
            cyl1--;
            firstInfoArea.Text = cyl1.ToString();
        }

        private void secondHeightBox_TextChanged(object sender, TextChangedEventArgs e)
        {
            try
            {
                cyl2.Height = validateData(secondHeightBox);
                cyl2.Radius = validateData(secondRadiusBox);
                secondInfoArea.Text = cyl2.ToString();
            }
            catch (Exception ex)
            {
                secondInfoArea.Text = "Неверные данные";
            }
        }

        private void secondRadiusBox_TextChanged(object sender, TextChangedEventArgs e)
        {
            try
            {
                cyl2.Height = validateData(secondHeightBox);
                cyl2.Radius = validateData(secondRadiusBox);
                secondInfoArea.Text = cyl2.ToString();
            }
            catch (Exception ex)
            {
                secondInfoArea.Text = "Неверные данные";
            }
        }

        private void secondIncrementButton_Click(object sender, RoutedEventArgs e)
        {
            cyl2--;
            secondInfoArea.Text = cyl2.ToString();
        }

        private void plusButton_Click(object sender, RoutedEventArgs e)
        {
            thirdInfoArea.Text = "Сумма радиусов равна " + (cyl1 + cyl2);
        }

        private void multiplyButton_Click(object sender, RoutedEventArgs e)
        {
            thirdInfoArea.Text = "Информация о цилиндре с наибольшим объёмом:\n" + cyl1 * cyl2;
        }

        private void compareButton_Click(object sender, RoutedEventArgs e)
        {
            if (cyl1.Volume == cyl2.Volume) thirdInfoArea.Text = "Объёмы цилиндров равны.";
            else thirdInfoArea.Text = "Объём первого цилиндра " + (cyl1 > cyl2 ? "больше" : "меньше") + " объёма второго.";
        }
    }
}
