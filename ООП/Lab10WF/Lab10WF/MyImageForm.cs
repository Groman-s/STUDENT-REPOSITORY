using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Lab10WF
{
    public partial class MyImageForm : Form
    {
        private bool drawMode = false;
        public MyImageForm()
        {
            InitializeComponent();
            pictureBox1.ContextMenuStrip = contextMenuStrip1;
            openFileDialog1.Filter = "Изображения|*.jpeg;*.jpg;*.png";
            saveFileDialog1.Filter = "Изображения|*.jpeg;*.jpg;*.png";

            ToolTip t = new ToolTip();
            t.SetToolTip(pictureBox1, "ПКМ для меню. Двойной клик для открытия нового изображения. ЛКМ и удерживание для рисования.");
        }

        private void открытьToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (openFileDialog1.ShowDialog() != DialogResult.Cancel)
            {
                pictureBox1.SizeMode = PictureBoxSizeMode.StretchImage;
                pictureBox1.Image = Image.FromFile(openFileDialog1.FileName);
                fileNameStatus.Text = openFileDialog1.FileName;
            }
        }

        private void закрытьToolStripMenuItem_Click(object sender, EventArgs e)
        {
            pictureBox1.Image = new Bitmap(pictureBox1.Width, pictureBox1.Height);
        }

        private void pictureBox1_Click(object sender, EventArgs e)
        {
            if (openFileDialog1.ShowDialog() != DialogResult.Cancel)
            {
                pictureBox1.SizeMode = PictureBoxSizeMode.StretchImage;
                pictureBox1.Image = Image.FromFile(openFileDialog1.FileName);
                fileNameStatus.Text = openFileDialog1.FileName;
            }
        }

        private void pictureBox1_MouseDown(object sender, MouseEventArgs e)
        {
            drawMode = true;
        }

        private void pictureBox1_MouseUp(object sender, MouseEventArgs e)
        {
            drawMode = false;
        }

        private void pictureBox1_MouseMove(object sender, MouseEventArgs e)
        {
            if (!drawMode) return;
            if (e.Button != MouseButtons.Left) return;
            if (pictureBox1.Image == null)
            {
                pictureBox1.Image = new Bitmap(pictureBox1.Width, pictureBox1.Height);
            }
            using (Graphics g = Graphics.FromImage(pictureBox1.Image))
            {
                double scaleX = (double)pictureBox1.Image.Width / pictureBox1.Width;
                double scaleY = (double)pictureBox1.Image.Height / pictureBox1.Height;
                g.FillEllipse(Brushes.Red, new Rectangle((int)(e.X * scaleX), (int)(e.Y * scaleY), (int)(8 * scaleX), (int)(8 * scaleY)));
                g.SmoothingMode = System.Drawing.Drawing2D.SmoothingMode.AntiAlias;
            }
            pictureBox1.Invalidate();
        }

        private void сохранитьToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (saveFileDialog1.ShowDialog() != DialogResult.Cancel)
            {
                pictureBox1.Image.Save(saveFileDialog1.FileName);
            }
        }
    }
}
