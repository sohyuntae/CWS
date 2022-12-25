import React from "react";

import Box from "@mui/material/Box";
import Toolbar from "@mui/material/Toolbar";

import { menus } from "@/assets/data/menus";
import Drawer from "@/components/Drawer";
import { Container } from "@mui/material";
import Header from "@/components/Header";

interface Props {
  window?: () => Window;
  children?: React.ReactNode;
}

export default function MainLayout(props: Props) {
  const { window } = props;
  const [mobileOpen, setMobileOpen] = React.useState(false);
  const handleDrawerToggle = () => {
    setMobileOpen(!mobileOpen);
  };

  return (
    <Box>
      <Header menus={menus} handleDrawerToggle={handleDrawerToggle} />
      <Box component="nav">
        <Drawer window={window} menus={menus} mobileOpen={mobileOpen} handleDrawerToggle={handleDrawerToggle} />
      </Box>
      <Box component="main" sx={{ p: 3 }}>
        <Toolbar />
        <Container maxWidth="xl">{props.children}</Container>
      </Box>
    </Box>
  );
}
