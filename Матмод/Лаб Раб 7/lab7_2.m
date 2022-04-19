function [t,State]=DiscretMarcProc
    P0 = [0, 0, 0, 0.1, 0.2, 0.4, 0.3];
    Tm = 501;
    A = [
        0.1, 0.5, 0.4, 0, 0, 0, 0;
        0, 0.7, 0.3, 0, 0, 0, 0;
        0.2, 0.1, 0.7, 0, 0, 0, 0;
        0, 0, 0, 0.3, 0.1, 0, 0.6;
        0.1, 0.7, 0, 0.1, 0, 0.1, 0;
        0.9, 0, 0, 0, 0, 0.1, 0;
        0, 0, 0, 0.3, 0.1, 0.2, 0.4;
    ];
    z = rand;
    P0s = cumsum(P0);
    k = 1;
    while z > P0s(1,k)
        k = k + 1;
    end
    ks = 1;
    State(ks)=k;
    for ks=2:Tm
        p=A(k,:);
        ps = cumsum(p);
        k=1; z=rand;
        while z > ps(1,k)
            k = k+1;
        end
        State(ks) = k;
    end
    t = 0:Tm-1;
end