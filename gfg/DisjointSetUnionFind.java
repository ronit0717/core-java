class GfG {
    int find(int par[], int x) {
        // add code here.
        if(par[x] == x) {
            return x;
        }
        int ultimateParent = find(par, par[x]);
        par[x] = ultimateParent; //path compression
        return ultimateParent;
    }

    void unionSet(int par[], int x, int z) {
        // add code here.
        int ultimateParentX = find(par, x);
        int ultimateParentZ = find(par, z);
        if (ultimateParentX == ultimateParentZ) {
            return; //both already unioned
        }
        par[ultimateParentX] = ultimateParentZ;
    }
}
