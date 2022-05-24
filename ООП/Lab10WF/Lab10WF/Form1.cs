namespace Lab10WF
{
    public partial class Form1 : Form
    {
        private Form[] forms = new Form[4];

        public void reloadForms()
        {
            foreach (Form f in forms) f?.Close();

            forms[0] = new MyTextForm();// верхн€€
            forms[0].Size = new Size(this.ClientSize.Width - 5, this.Height / 3);

            forms[1] = new MyImageForm();// лева€
            forms[1].Size = new Size(this.ClientSize.Width / 3 - 5, this.ClientSize.Height * 2 / 3 - 45);
            forms[1].Location = new Point(0, forms[0].Height);

            forms[2] = new MyTextForm();// центральна€
            forms[2].Size = new Size(this.ClientSize.Width / 3 - 5, this.ClientSize.Height * 2 / 3 - 45);
            forms[2].Location = new Point(this.ClientSize.Width / 3, forms[0].Height);

            forms[3] = new MyImageForm();// права€
            forms[3].Size = new Size(this.ClientSize.Width / 3 - 5, this.ClientSize.Height * 2 / 3 - 45);
            forms[3].Location = new Point(this.ClientSize.Width * 2 / 3, forms[0].Height);

            foreach (Form f in forms)
            {
                f.MdiParent = this;
                f.StartPosition = FormStartPosition.Manual;
                f.Show();
            }
        }

        public Form1()
        {
            InitializeComponent();
            

            this.Width += 8;
            this.Height += 22;
            reloadForms();
        }

        private void перезагрузить¬се‘ормыToolStripMenuItem_Click(object sender, EventArgs e)
        {
            reloadForms();
        }
    }
}