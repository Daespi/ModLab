import { Component, OnInit } from '@angular/core';
import { Cpu } from '../../models/Cpu/Cpu';
import { CpuService } from '../../services/cpu/cpu.service';
import { CommonModule } from '@angular/common';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-cpu',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './cpu.component.html',
  styleUrls: ['./cpu.component.css'] // <- aquí va en plural
})
export class CpuComponent {}

@Component({
  selector: 'app-cpu-list',
  templateUrl: './cpu-list.component.html'
})
export class CpuListComponent implements OnInit {
  cpus: Cpu[] = [];

  constructor(private cpuService: CpuService) {}

  ngOnInit(): void {
    this.cpuService.getAllCpus().subscribe(data => {
      this.cpus = data;
    });
  }
}


export class CpuDetailComponent implements OnInit {
  cpu?: Cpu;

  constructor(private cpuService: CpuService, private route: ActivatedRoute) {}

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.cpuService.getCpuById(id).subscribe(data => {
      this.cpu = data;
    });
  }
}
