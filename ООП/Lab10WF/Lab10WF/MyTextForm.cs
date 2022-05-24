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
    public partial class MyTextForm : Form
    {
        public MyTextForm()
        {
            InitializeComponent();
            saveFileDialog1.Filter = "Текстовые файлы(*.txt)|*.txt|Все файлы(*.*)|*.*";
        }

        private void richTextBox1_TextChanged(object sender, EventArgs e)
        {
            statusNum.Text = richTextBox1.Text.Length.ToString();
        }

        private void открытьToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (openFileDialog1.ShowDialog() != DialogResult.Cancel)
            {
                richTextBox1.Text = File.ReadAllText(openFileDialog1.FileName);
            }
        }

        private void сохранитьToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (saveFileDialog1.ShowDialog() != DialogResult.Cancel)
            {
                File.WriteAllText(saveFileDialog1.FileName, richTextBox1.Text);
            }
        }

        private void очиститьToolStripMenuItem_Click(object sender, EventArgs e)
        {
            richTextBox1.Text = "";
        }
    }
}
