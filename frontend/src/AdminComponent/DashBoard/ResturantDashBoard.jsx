import { Grid } from "@mui/material";
import React from "react";
import { MenuTable } from "../Menu/MenuTable";
import { OrderTable } from "../Orders/OrderTable";

export const ResturantDashBoard = () => {
  return (
    <div>
      <Grid container spacing={2}>
        <Grid item sx={12} lg={12}>
          <MenuTable />
        </Grid>

        <Grid item sx={12} lg={12}>
          <OrderTable />
        </Grid>
      </Grid>
    </div>
  );
};
