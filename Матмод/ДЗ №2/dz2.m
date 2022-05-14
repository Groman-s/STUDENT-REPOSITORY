clear, clc
Tm = 31; % �����
R = 10;
msr = 50;
Qmin = 200; % ����������� ����� ������
qmin = 10; % ����������� �����
Q = zeros(1,Tm); % ����� ������
q = zeros(1,Tm); % ������� �����
r = zeros(1,Tm); % �������� ��������
Q(1) = 0; % ����� ������ �� ������ ����
q(1) = 100; % ����� �� ������ ����
r(1) = 0; % ������� �� ������ ����

for j = 2 : Tm
    m(j) = unifrnd(0,2*msr);
    qv = q(j-1)+Q(j-1)-m(j);
    if qv >= 0
        q(j) = qv;
    else
        q(j) = 0;
    end
    
    if qv < 0
        r(j) = -qv;
    else
        r(j) = 0;
    end
    
    if q(j) < qmin
        Q(j) = Qmin + R * r(j);
    else
        Q(j) = 0;
    end
end
t = 0:Tm-1;
stem(t,q) ; hold on, stem(t,Q), hold on, stem(t,r)