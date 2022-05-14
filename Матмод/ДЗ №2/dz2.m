clear, clc
Tm = 31; % суток
R = 10;
msr = 50;
Qmin = 200; % минимальный объём заказа
qmin = 10; % критический запас
Q = zeros(1,Tm); % Объём заказа
q = zeros(1,Tm); % текущий запас
r = zeros(1,Tm); % величина дефицита
Q(1) = 0; % объём заказа на первый день
q(1) = 100; % запас на первый день
r(1) = 0; % дефицит на первый день

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