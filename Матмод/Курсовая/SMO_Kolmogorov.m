function [ p ] = SMO_Kolmogorov;
    L = 3; mu = 2; v = 1;
    
    dt = 0.01;
    T = 400;
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
    figure; gr=plot(t,p); title('Вероятности', 'FontName','Arial Unicode MS');
    xlabel('t'); ylabel('P');
end