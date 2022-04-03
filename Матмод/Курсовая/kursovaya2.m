clear, clc
l = 3; % интенсивность поступающих заявок
R = 1; % ёмкость накопителя
M = 2; % число обслуживающих каналов
mu = 2; % Интенсивность обслуживания заявок
v = 1;
C1 = 300;
C2 = 14;
C3 = 25;
C4 = 19;

Ns = M + R + 1; % число состояний

ro = l/mu;
p = zeros(Ns,1); % вероятности состояний

p(1) = 1;
s = 1;
for i = 2 : M + 1
    s = s * ro / (i-1);
    p(1) = p(1) + s;
end

for i = M + 2 : Ns
    s = s * l / (M*mu + (i-1-M)*v);
    p(1) = p(1) + s;
end

p(1) = 1 / p(1);

for i = 2 : M + 1
    p(i) = p(i-1) * ro / (i-1);
end

for i = M+2 : Ns
    p(i) = p(i-1) * l / (M*mu+(i-1-M)*v);
end

disp('=Вероятности=');
for i = 1 : Ns
    fprintf('p(%d)=%f\r', i-1, p(i));
end
fprintf('\n');

% ==================================================

n = 0;
for i = 1 : Ns
    n = n + (i-1) * p(i);
end
fprintf('Число заявок в системе = %f\r\n', n);

Ms = 0;
for i = 1 : M
    Ms = Ms + (M - i + 1) * p(i);
end
fprintf('Число свободных каналов = %f\r\n', Ms);

Mz = M - Ms;
fprintf('Число занятых каналов = %f\r\n', Mz);

r = 0;
for i = M + 2 : Ns
    r = r + (i - 1 - M) * p(i);
end
fprintf('Длина очереди = %f\r\n', r);

Potk = p(Ns);
fprintf('Вероятность отказа = %f\r\n', Potk);

lotk = l*Potk;
fprintf('Поток отказов = %f\r\n', lotk);

pneterp = v*p(4);
fprintf('Поток нетерпеливых заявок = %f\r\n', pneterp);

A = l - lotk - pneterp;
fprintf('Абсолютная пропускная способность = %f\r\n', A);

q = A / l;
fprintf('Относительная пропускная способность = %f\r\n', q);

Dneobsl = (Potk+lotk)/l;
fprintf('Доля необслуженных заявок = %f\r\n', Dneobsl);

Dotk = lotk / l;
fprintf('Доля заявок, получивших отказ в обслуживании = %f\r\n', Dotk);

ts = n / A;
fprintf('Время пребывания заявки в системе = %f\r\n', ts);

tog = r / A;
fprintf('Время ожидания в очереди = %f\r\n', tog);

tobsl = 1 / mu;
fprintf('Время обслуживания = %f\r\n', tobsl);

W = C1*Ms + C2*r + C3*(lotk+pneterp) - C4*A;
fprintf('Затраты на функционирование системы = %f\r\n', W);