function [ p, n, Ms, Mz, r, Potk, lotk, lneterp, q, A, Dneobsl, Dotk, ts, tog, tobsl, W ] = SMO_Kolmogorov_raschet
    L = 3; mu = 2; R = 1; M = 2;
    C1 = 300; C2 = 14; C3 = 25; C4 = 19; v = 1;
    
    dt = 0.01;
    T = 1000;
    Ns = 4;
    Ed = eye(Ns);
    Ap = [
        -L, mu, 0, 0;
        L, -(L+mu), 2*mu, 0;
        0, L, -(L+2*mu), 2*mu+v;
        0, 0, L, -(2*mu+v);
    ];
    D = Ed+dt*Ap;
    p=zeros(Ns,T);

    p(:,1)=[1;0;0;0];
    for t=2:T
        p(:,t)=D*p(:,t-1);
    end
    t = 1:T;
    
    n = zeros(T,1); Ms = zeros(T,1); Mz = zeros(T,1); r = zeros(T,1);
    Potk = zeros(T,1); lotk = zeros(T,1); lneterp = zeros(T,1); q = zeros(T,1); A = zeros(T,1);
    Dneobsl = zeros(T,1); Dotk = zeros(T,1); ts = zeros(T,1); tog = zeros(T,1);
    tobsl = zeros(T,1); W = zeros(T,1);
    
    for t=1:T
        for i=1:Ns
            n(t,1)=n(t,1)+(i-1)*p(i,t);
        end
        
        for i=1:M
            Ms(t,1)=Ms(t,1)+(M-i+1)*p(i,t);
        end
        
        Mz(t,1)=M-Ms(t,1);
        
        for i=M+2:Ns
            r(t,1)=r(t,1)+(i-1-M)*p(i,t);
        end
        
        Potk(t,1)=p(Ns,t);
        lotk(t,1)=L*Potk(t,1);
        
        for i=M+2:Ns
            lneterp(t,1)=lneterp(t,1)+(i-1-M)*v*p(i,t);
        end
        
       
        A(t,1)=L-lotk(t,1)-lneterp(t,1);
        q(t,1)=A(t,1)/L;
        Dneobsl(t,1)=(lotk(t,1)+lneterp(t,1))/L;
        Dotk(t,1)=lotk(t,1)/L;
        ts(t,1)=n(t,1)/A(t,1);
        tobsl(t,1)=1/mu;
        tog(t,1)=ts(t,1)-tobsl(t,1);
        W(t,1)=C1*Ms(t,1)+C2*r(t,1)+C3*lotk(t,1)-C4*A(t,1);
    end
    t=1:T;
    
    figure; plot(t,n); title('����� ������ � �������'); xlabel('t'); ylabel('n');
    figure; plot(t,Ms); title('����� ��������� �������'); xlabel('t'); ylabel('Ms');
    figure; plot(t,Mz); title('����� ������� �������'); xlabel('t'); ylabel('Mz');
    figure; plot(t,r); title('����� �������'); xlabel('t'); ylabel('r');
    figure; plot(t,Potk); title('����������� ������'); xlabel('t'); ylabel('Potk');
    figure; plot(t,lotk); title('����� �������'); xlabel('t'); ylabel('lotk');
    figure; plot(t,lneterp); title('����� ������������ ������'); xlabel('t'); ylabel('lneterp');
    figure; plot(t,A); title('���������� ���������� �����������'); xlabel('t'); ylabel('A');
    figure; plot(t,q); title('������������� ���������� �����������'); xlabel('t'); ylabel('q');
    figure; plot(t,Dneobsl); title('���� �� ����������� ������'); xlabel('t'); ylabel('Dneobsl');
    figure; plot(t,Dotk); title('���� ������, ���������� ����� � ������������'); xlabel('t'); ylabel('Dotk');
    figure; plot(t,ts); title('����� ���������� ������ � �������'); xlabel('t'); ylabel('ts');
    figure; plot(t,tobsl); title('����� ������������'); xlabel('t'); ylabel('tobsl');
    figure; plot(t,tog); title('����� �������� � �������'); xlabel('t'); ylabel('tog');
    figure; plot(t,W); title('������� �� ���������������� �������'); xlabel('t'); ylabel('W');

end