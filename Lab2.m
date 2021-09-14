clear, clc
x = -2:0.005:-0.1;
y = log(1./(x.^2+2.*x+2));
xMax = fminbnd(@(x)-log(1/(x^2+2*x+2)), -2, -0.1);
yMax = log(1/(xMax^2+2*xMax+2));
hold on
plot(x, y), grid on
plot(xMax, yMax, '*r')
text(xMax-0.01, yMax-0.01, '��������', 'FontSize', 12)
xlabel('�������� ��������� (x)', 'FontSize', 12, 'FontAngle', 'italic')
ylabel('�������� ������� (y)', 'FontSize', 12, 'FontAngle', 'italic')
title('������ ������� y = ln(1/(x^2+2x+2))', 'FontSize', 16, 'FontWeight', 'bold')
legend('y = ln(1/(x^2+2x+2))', '����� ���������', 'Location', 'southwest', 'FontSize', 12)
hold off
fprintf('����� ���������: x = %0.3f. ��������: y = %0.3f', xMax, yMax)