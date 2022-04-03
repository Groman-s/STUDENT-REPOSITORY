function [mu,W]=kursovaya2_2(muMin,muMax,h)

l = 3; % интенсивность поступающих заявок
R = 1; % ёмкость накопителя
M = 2; % число обслуживающих каналов
v = 1;
C1 = 300;
C2 = 14;
C3 = 25;
C4 = 19;

mu = muMin:h:muMax;
D = size(mu);

W = zeros(D(1),1);

Ns = M + R + 1;

Wmin = 0;

for k=muMin:h:muMax
    ro = l/mu(k);
    p = zeros(Ns,1);

    p(1) = 1;
    s = 1;
    for i = 2 : M + 1
        s = s * ro / (i-1);
        p(1) = p(1) + s;
    end

    for i = M + 2 : Ns
        s = s * l / (M*mu(k) + (i-1-M)*v);
        p(1) = p(1) + s;
    end

    p(1) = 1 / p(1);

    for i = 2 : M + 1
        p(i) = p(i-1) * ro / (i-1);
    end

    for i = M+2 : Ns
        p(i) = p(i-1) * l / (M*mu(k)+(i-1-M)*v);
    end

    n = 0;
    for i = 1 : Ns
        n = n + (i-1) * p(i);
    end

    Ms = 0;
    for i = 1 : M
        Ms = Ms + (M - i + 1) * p(i);
    end

    Mz = M - Ms;

    r = 0;
    for i = M + 2 : Ns
        r = r + (i - 1 - M) * p(i);
    end

    Potk = p(Ns);

    lotk = l*Potk;

    pneterp = v*p(4);

    A = l - lotk - pneterp;

    q = A / l;

    Dneobsl = (Potk+lotk)/l;

    Dotk = lotk / l;

    ts = n / A;

    tog = r / A;

    tobsl = 1 / mu(k);

    W(k) = C1*Ms + C2*r + C3*(lotk+pneterp) - C4*A;
    fprintf('mu=%f    W=%f\r', mu(k), W(k));
    
    if ((k == 1) || ((k~=1) && (W(k)<Wmin)))
        Wmin = W(k);
        kmin=k;
    end
end

fprintf('kmin=%d    Wmin=%f\r\n', kmin, Wmin);
