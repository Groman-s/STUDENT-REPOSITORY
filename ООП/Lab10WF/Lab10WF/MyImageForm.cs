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
        public MyImageForm()
        {
            InitializeComponent();
            pictureBox1.ContextMenuStrip = contextMenuStrip1;
            openFileDialog1.Filter = "Изображения|*.jpeg;*.jpg;*.png";
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
            pictureBox1.Image = null;
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
    }
}
